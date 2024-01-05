import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalculatorGUI {
    private JFrame frame;
    private JTextField txtDisplay;
    private double firstNumber;
    private String operator;

    public SimpleCalculatorGUI() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        txtDisplay = new JTextField();
        txtDisplay.setFont(new Font("Arial", Font.PLAIN, 24));
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(txtDisplay, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        // Create buttons for digits (0-9) and operators (+, -, *, /)
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));

            // For digits and decimal point, add action listener to append the clicked value to the text field
            if (label.matches("[0-9.]")) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtDisplay.setText(txtDisplay.getText() + label);
                    }
                });
            }
            // For operators, add action listener to handle the operator and store the first operand
            else if (label.matches("[-+*/]")) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        operator = label;
                        firstNumber = Double.parseDouble(txtDisplay.getText());
                        txtDisplay.setText("");
                    }
                });
            }
            // For "=", add action listener to perform the calculation and display the result
            else if (label.equals("=")) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        double secondNumber = Double.parseDouble(txtDisplay.getText());
                        double result = 0;

                        // Perform the appropriate operation based on the operator
                        switch (operator) {
                            case "+":
                                result = firstNumber + secondNumber;
                                break;
                            case "-":
                                result = firstNumber - secondNumber;
                                break;
                            case "*":
                                result = firstNumber * secondNumber;
                                break;
                            case "/":
                                result = firstNumber / secondNumber;
                                break;
                        }

                        // Display the result in the text field
                        txtDisplay.setText(Double.toString(result));
                    }
                });
            }
            // For "C" (clear), add action listener to reset the text field
            else if (label.equals("C")) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtDisplay.setText("");
                    }
                });
            }

            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculatorGUI();
            }
        });
    }
}
