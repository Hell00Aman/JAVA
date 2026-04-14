import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class
public class EmployeeRegistrationForm {

    public static void main(String[] args) {

        // Create frame with title
        JFrame frame = new JFrame("Employee Registration Form");
        frame.setSize(400, 400); // Fixed size
        frame.setLayout(null);   // Manual layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel nameLabel = new JLabel("Employee Name:");
        nameLabel.setBounds(30, 30, 120, 25);
        frame.add(nameLabel);

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(30, 70, 120, 25);
        frame.add(idLabel);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(30, 110, 120, 25);
        frame.add(deptLabel);

        JLabel desigLabel = new JLabel("Designation:");
        desigLabel.setBounds(30, 150, 120, 25);
        frame.add(desigLabel);

        // Text fields
        JTextField nameField = new JTextField();
        nameField.setBounds(160, 30, 180, 25);
        frame.add(nameField);

        JTextField idField = new JTextField();
        idField.setBounds(160, 70, 180, 25);
        frame.add(idField);

        JTextField deptField = new JTextField();
        deptField.setBounds(160, 110, 180, 25);
        frame.add(deptField);

        JTextField desigField = new JTextField();
        desigField.setBounds(160, 150, 180, 25);
        frame.add(desigField);

        // Output label
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(30, 260, 350, 60);
        frame.add(resultLabel);

        // Submit button
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(80, 200, 100, 30);
        frame.add(submitBtn);

        // Reset button
        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(200, 200, 100, 30);
        frame.add(resetBtn);

        // Action for Submit button
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Get values from text fields
                String name = nameField.getText();
                String id = idField.getText();
                String dept = deptField.getText();
                String desig = desigField.getText();

                // Display entered data
                resultLabel.setText("<html>Name: " + name +
                        "<br>ID: " + id +
                        "<br>Dept: " + dept +
                        "<br>Designation: " + desig + "</html>");
            }
        });

        // Action for Reset button
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Clear all fields
                nameField.setText("");
                idField.setText("");
                deptField.setText("");
                desigField.setText("");
                resultLabel.setText("");
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
