package interfata;

import dataModel.Polinom;
import dataModel.PolinomIntrareGresit;
import operatii.Operatii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata implements ActionListener{
    JFrame frame;
    JPanel panel;
    JButton addButton, subtractButton, integrateButton, deriveButton, multiplyButton, reset;
    JTextField poly1TextField, poly2TextField, poly3TextField;
    JLabel resultLabel, errorLabel, poly1Label, poly2Label;

    private final Operatii operatii = new Operatii();

    public Interfata() {
        // Create the frame and panel
        JFrame frame = new JFrame();
        frame.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        frame.setTitle("Polynomial Calculator ♥");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

       //creare butoane si text fields
        addButton = new JButton("adunare");
        addButton.setBackground(Color.cyan);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));

        subtractButton = new JButton("scadere");
        subtractButton.setBackground(Color.cyan);
        subtractButton.setFont(new Font("Arialn", Font.BOLD, 16));

        integrateButton = new JButton("integrare");
        integrateButton.setBackground(Color.cyan);
        integrateButton.setFont(new Font("Arial", Font.BOLD, 16));

        deriveButton = new JButton("derivare");
        deriveButton.setBackground(Color.cyan);
        deriveButton.setFont(new Font("Arial", Font.BOLD, 16));

        multiplyButton = new JButton("inmultire");
        multiplyButton.setBackground(Color.cyan);
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 16));

        reset = new JButton("reset");
        reset.setBackground(Color.green);
        reset.setFont(new Font("Arial", Font.BOLD, 16));

        poly1TextField = new JTextField();
        poly2TextField = new JTextField();

        poly3TextField = new JTextField(JTextField.RIGHT);

        poly3TextField.setFont(new Font("Arial", Font.BOLD, 14));
        poly1TextField.setFont(new Font("Arial", Font.BOLD, 14));
        poly2TextField.setFont(new Font("Arial", Font.BOLD, 14));


        //Creare label standar, titlu
        resultLabel = new JLabel("Rezultat:");
        resultLabel.setPreferredSize(new Dimension(20, 10));
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        errorLabel = new JLabel("");

        poly1Label = new JLabel("Polinom 1:");
        poly1Label.setFont(new Font("Arial", Font.PLAIN, 18));
        poly2Label = new JLabel("Polinom 2:");
        poly2Label.setFont(new Font("Arial", Font.PLAIN, 18));

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        integrateButton.addActionListener(this);
        deriveButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        reset.addActionListener(this);

        panel.add(poly1Label);
        panel.add(poly1TextField);
        panel.add(poly2Label);
        panel.add(poly2TextField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(integrateButton);
        panel.add(deriveButton);
        panel.add(multiplyButton);
        panel.add(reset);

        panel.add(resultLabel);
        panel.add(poly3TextField);

        frame.add(panel);

        // Setare dimensiune, vizibill si pozitie pe ecran pt frame
        frame.setSize(600, 300);
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
       String op = ((JButton) e.getSource()).getText();
        Polinom rezultat;

        try{
            if(op.equals("adunare")){
                rezultat = operatii.adunare(operatii.parsarePolinom(poly1TextField.getText()), operatii.parsarePolinom(poly2TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }

            if(op.equals("scadere")){
                rezultat = operatii.scadere(operatii.parsarePolinom(poly1TextField.getText()), operatii.parsarePolinom(poly2TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }

            if(op.equals("derivare")){
                rezultat = operatii.derivare(operatii.parsarePolinom(poly1TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }
            if(op.equals("integrare")){
                rezultat = operatii.integrare(operatii.parsarePolinom(poly1TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }
            if(op.equals("inmultire")){
                rezultat = operatii.inmultire(operatii.parsarePolinom(poly1TextField.getText()), operatii.parsarePolinom(poly2TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }
            if(op.equals("reset")){
                poly1TextField.setText("");
                poly2TextField.setText("");
                poly3TextField.setText("");
            }

        } catch (PolinomIntrareGresit ex) {
            JOptionPane.showMessageDialog(null, "Date introduse gresit", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }

    }