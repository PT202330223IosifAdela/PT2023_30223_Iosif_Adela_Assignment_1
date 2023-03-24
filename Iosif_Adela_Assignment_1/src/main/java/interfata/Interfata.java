package interfata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata implements ActionListener{
    JFrame frame;
    JPanel panel;
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JTextField poly1TextField, poly2TextField, poly3TextField;
    JLabel resultLabel, errorLabel, poly1Label, poly2Label;

    //JTextField

    public Interfata() {
        // Create the frame and panel
        JFrame frame = new JFrame();
        frame.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        frame.setTitle("Polynomial Calculator \u2665"); //caracter inimioara
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

       //creare butoane si text fields
        addButton = new JButton("Add");
        addButton.setBackground(Color.cyan);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));

        subtractButton = new JButton("Subtract");
        subtractButton.setBackground(Color.cyan);
        subtractButton.setFont(new Font("Arialn", Font.BOLD, 16));

        multiplyButton = new JButton("Multiply");
        multiplyButton.setBackground(Color.cyan);
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 16));

        divideButton = new JButton("Divide");
        divideButton.setBackground(Color.cyan);
        divideButton.setFont(new Font("Arial", Font.BOLD, 16));

        poly1TextField = new JTextField();
        poly2TextField = new JTextField();

        poly3TextField = new JTextField("0");
        poly3TextField.setEditable(false);
        poly3TextField.setFont(new Font("Arial", Font.BOLD, 14));
        poly1TextField.setFont(new Font("Arial", Font.BOLD, 14));
        poly2TextField.setFont(new Font("Arial", Font.BOLD, 14));


        //Creare label standar, titlu
        resultLabel = new JLabel("Rezultat:");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        errorLabel = new JLabel("");

        poly1Label = new JLabel("Polinom 1:");
        poly1Label.setFont(new Font("Arial", Font.PLAIN, 18));
        poly2Label = new JLabel("Polinom 2:");
        poly2Label.setFont(new Font("Arial", Font.PLAIN, 18));

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
        panel.add(poly3TextField);

        frame.add(panel);

        // Setare dimensiune, vizibill si pozitie pe ecran pt frame
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  //afisare interfata pe centrul ecranului

        //imagine
        ImageIcon imageCalc = new ImageIcon("calculator.png");
        JLabel labelIm = new JLabel(imageCalc);
        labelIm.setBounds(20, 20, imageCalc.getIconWidth(), imageCalc.getIconHeight());
        frame.add(labelIm);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String poly1String = poly1TextField.getText();
        String poly2String = poly2TextField.getText();
        Interfata poly1 = null, poly2 = null;
        String errorMessage = "";

        if (e.getSource() == addButton) {
            if (poly1 != null && poly2 != null) {
              //  resultLabel.setText("Rezultat: " + poly1.add(poly2).toString());
                errorLabel.setText("");
            } else {
                errorLabel.setText(errorMessage);
            }
        } else if (e.getSource() == subtractButton) {
            if (poly1 != null && poly2 != null) {
               // resultLabel.setText("Rezultat: " + poly1.subtract(poly2).toString());
                errorLabel.setText("");
            } else {
                errorLabel.setText(errorMessage);
            }
        } else if (e.getSource() == multiplyButton) {
            if (poly1 != null && poly2 != null) {
              //  resultLabel.setText("Rezultat: " + poly1.multiply(poly2).toString());
                errorLabel.setText("");
            } else {
                errorLabel.setText(errorMessage);
            }
        }

        }

    }