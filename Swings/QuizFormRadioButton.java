// File: QuizFormRadioButton.java

import javax.swing.*;
import java.awt.*;

public class QuizFormRadioButton {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Simple Quiz");

        // Set layout
        frame.setLayout(new FlowLayout());

        // Create question label
        JLabel question = new JLabel("Which language is used for Android development?");

        // Create radio buttons (options)
        JRadioButton option1 = new JRadioButton("Java");
        JRadioButton option2 = new JRadioButton("Python");
        JRadioButton option3 = new JRadioButton("C++");
        JRadioButton option4 = new JRadioButton("HTML");

        // Group radio buttons so only one can be selected
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        // Create submit button
        JButton submitButton = new JButton("Submit");

        // Add components to frame
        frame.add(question);
        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);
        frame.add(submitButton);

        // Frame settings
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
