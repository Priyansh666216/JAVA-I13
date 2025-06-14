


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JButton addBtn;
    private JButton multiplyBtn;

    public Calculator() {
        setLayout(new BorderLayout());


        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel headerLabel = new JLabel("yaroub laika- Roll No: 2306400");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(headerLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel num1Label = new JLabel("Number 1:");
        num1Field = new JTextField(10);
        JLabel num2Label = new JLabel("Number 2:");
        num2Field = new JTextField(10);
        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);


        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new FlowLayout());
        addBtn = new JButton("Add");
        multiplyBtn = new JButton("Multiply");
        operationPanel.add(addBtn);
        operationPanel.add(multiplyBtn);


        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);


        add(headerPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(operationPanel, BorderLayout.LINE_START);
        add(resultPanel, BorderLayout.SOUTH);


        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performAddition();
            }
        });

        multiplyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performMultiplication();
            }
        });


        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void performAddition() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 + num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers.");
        }
    }

    private void performMultiplication() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 * num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}


