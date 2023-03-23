package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata implements ActionListener{
    JFrame frame;
    JPanel panel;
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JTextField poly1TextField, poly2TextField;
    JLabel resultLabel, errorLabel, poly1Label, poly2Label;


  /*  private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;*/
    public Interfata() {
        // Create the frame and panel
        frame = new JFrame("Polynomial Calculator");
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Create the buttons and text fields
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        poly1TextField = new JTextField();
        poly2TextField = new JTextField();

        // Create the labels
        resultLabel = new JLabel("Result:");
        errorLabel = new JLabel("");
        poly1Label = new JLabel("Polynomial 1:");
        poly2Label = new JLabel("Polynomial 2:");

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);// Add the components to the panel
        panel.add(poly1Label);
        panel.add(poly1TextField);
        panel.add(poly2Label);
        panel.add(poly2TextField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(resultLabel);
        panel.add(errorLabel);

        // Add the panel to the frame
        frame.add(panel);

        // Set the size and visibility of the frame
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String poly1String = poly1TextField.getText();
        String poly2String = poly2TextField.getText();
        Interfata poly1 = null, poly2 = null;
        String errorMessage = "";

        // Parse the polynomials from the text fields
        /*try {
            poly1 = new Interfata(poly1String);
        } catch (IllegalArgumentException ex) {
            errorMessage += "Invalid polynomial 1: " + ex.getMessage() + "\n";
        }

        try {
            poly2 = new Interfata(poly2String);
        } catch (IllegalArgumentException ex) {
            errorMessage += "Invalid polynomial 2: " + ex.getMessage() + "\n";
        }*/
        // Perform the operation and display the result or error message
        if (e.getSource() == addButton) {
            if (poly1 != null && poly2 != null) {
              //  resultLabel.setText("Result: " + poly1.add(poly2).toString());
                errorLabel.setText("");
            } else {
                errorLabel.setText(errorMessage);
            }
        } else if (e.getSource() == subtractButton) {
            if (poly1 != null && poly2 != null) {
               // resultLabel.setText("Result: " + poly1.subtract(poly2).toString());
                errorLabel.setText("");
            } else {
                errorLabel.setText(errorMessage);
            }
        } else if (e.getSource() == multiplyButton) {
            if (poly1 != null && poly2 != null) {
              //  resultLabel.setText("Result: " + poly1.multiply(poly2).toString());
                errorLabel.setText("");
            } else {
                errorLabel.setText(errorMessage);
            }
        }

        }

    }