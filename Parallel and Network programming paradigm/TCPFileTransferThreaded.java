// File: TCPFileTransferThreaded.java

import java.io.*;
import java.net.*;

// -------- SERVER THREAD --------
class ServerThread extends Thread {
    public void run() {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Input stream to receive file data
            InputStream in = socket.getInputStream();

            // File to save received data
            FileOutputStream fileOut = new FileOutputStream("received.txt");

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read data and write to file
            while ((bytesRead = in.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
            }

            System.out.println("File received and saved as 'received.txt'");

            // Close resources
            fileOut.close();
            in.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// -------- CLIENT THREAD --------
class ClientThread extends Thread {
    public void run() {
        try {
            // Connect to server
            Socket socket = new Socket("localhost", 5000);

            // Output stream to send file data
            OutputStream out = socket.getOutputStream();

            // Read file to send
            FileInputStream fileIn = new FileInputStream("send.txt");

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Send file data
            while ((bytesRead = fileIn.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully");

            // Close resources
            fileIn.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// -------- MAIN CLASS --------
public class TCPFileTransferThreaded {
    public static void main(String[] args) throws InterruptedException {

        // Create server and client threads
        ServerThread server = new ServerThread();
        ClientThread client = new ClientThread();

        // Start server first
        server.start();

        // Small delay to ensure server starts first
        Thread.sleep(1000);

        // Start client
        client.start();

        // Wait for both threads to finish
        server.join();
        client.join();
    }
}
