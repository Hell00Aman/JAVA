// File: LoginFormFlowLayout.java

import javax.swing.*;
import java.awt.*;

public class LoginFormFlowLayout {

    public static void main(String[] args) {

        // Create a frame (window)
        JFrame frame = new JFrame("Login Form");

        // Set layout to FlowLayout
        frame.setLayout(new FlowLayout());

        // Create components
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        // Add components to frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(loginButton);

        // Frame settings
        frame.setSize(250, 150);           // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);            // Make frame visible
    }
}
