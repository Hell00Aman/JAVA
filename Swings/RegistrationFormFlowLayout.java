// File: RegistrationFormFlowLayout.java

import javax.swing.*;
import java.awt.*;

public class RegistrationFormFlowLayout {

    public static void main(String[] args) {

        // Create frame (window)
        JFrame frame = new JFrame("Registration Form");

        // Set layout to FlowLayout
        frame.setLayout(new FlowLayout());

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(5);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);

        JButton submitButton = new JButton("Submit");

        // Add components to frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(submitButton);

        // Frame settings
        frame.setSize(300, 180);                // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);                 // Display the form
    }
}
