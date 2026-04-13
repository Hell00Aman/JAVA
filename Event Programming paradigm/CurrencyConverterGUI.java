import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CurrencyConverterGUI {

    // Store predefined exchange rates (relative to USD)
    static HashMap<String, Double> rates = new HashMap<>();

    public static void main(String[] args) {

        // Initialize exchange rates
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.78);
        rates.put("JPY", 150.0);

        // Create frame
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Input field for amount
        JLabel amountLabel = new JLabel("Enter Amount:");
        JTextField amountField = new JTextField();

        // Dropdown for source currency
        JLabel fromLabel = new JLabel("From Currency:");
        String[] currencies = {"USD", "INR", "EUR", "GBP", "JPY"};
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);

        // Dropdown for target currency
        JLabel toLabel = new JLabel("To Currency:");
        JComboBox<String> toCurrency = new JComboBox<>(currencies);

        // Result label
        JLabel resultLabel = new JLabel("Converted Amount: ");

        // Convert button
        JButton convertButton = new JButton("Convert");

        // Action listener for button
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get user input
                    double amount = Double.parseDouble(amountField.getText());
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();

                    // Convert to USD first, then to target currency
                    double usdAmount = amount / rates.get(from);
                    double converted = usdAmount * rates.get(to);

                    // Display result
                    resultLabel.setText("Converted Amount: " + converted);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid Input!");
                }
            }
        });

        // Add components to frame
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(fromLabel);
        frame.add(fromCurrency);
        frame.add(toLabel);
        frame.add(toCurrency);
        frame.add(new JLabel()); // empty space
        frame.add(convertButton);
        frame.add(resultLabel);

        // Make frame visible
        frame.setVisible(true);
    }
}
