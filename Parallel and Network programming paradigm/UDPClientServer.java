// File: UDPClientServer.java

import java.net.*;

// -------- SERVER THREAD --------
class UDPServer extends Thread {
    public void run() {
        try {
            // Create DatagramSocket on port 5000
            DatagramSocket serverSocket = new DatagramSocket(5000);
            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            System.out.println("UDP Server is running...");

            // Receive packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            String clientMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + clientMsg);

            // Prepare response
            String response = "Message received: " + clientMsg;
            sendBuffer = response.getBytes();

            // Send response back to client
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// -------- CLIENT THREAD --------
class UDPClient extends Thread {
    public void run() {
        try {
            // Create DatagramSocket
            DatagramSocket clientSocket = new DatagramSocket();

            String message = "Hello Server!";
            byte[] sendBuffer = message.getBytes();

            // Send packet to server
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 5000);
            clientSocket.send(sendPacket);

            // Receive response
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String serverMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Response from server: " + serverMsg);

            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// -------- MAIN CLASS --------
public class UDPClientServer {
    public static void main(String[] args) throws InterruptedException {

        // Create server and client threads
        UDPServer server = new UDPServer();
        UDPClient client = new UDPClient();

        // Start server first
        server.start();

        // Small delay to ensure server is ready
        Thread.sleep(1000);

        // Start client
        client.start();

        // Wait for both to finish
        server.join();
        client.join();
    }
}
