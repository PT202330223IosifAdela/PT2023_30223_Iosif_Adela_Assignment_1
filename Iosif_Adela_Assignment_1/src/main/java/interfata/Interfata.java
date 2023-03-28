package interfata;

import dataModel.Polinom;
import dataModel.PolinomIntrareGresit;
import jdk.jshell.tool.JavaShellToolBuilder;
import operatii.Operatii;

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

    private Operatii operatii = new Operatii();

    public Interfata() {
        // Create the frame and panel
        JFrame frame = new JFrame();
        frame.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        frame.setTitle("Polynomial Calculator \u2665"); //caracter inimioara
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

       //creare butoane si text fields
        addButton = new JButton("+");
        addButton.setBackground(Color.cyan);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));

        subtractButton = new JButton("-");
        subtractButton.setBackground(Color.cyan);
        subtractButton.setFont(new Font("Arialn", Font.BOLD, 16));

        multiplyButton = new JButton("*");
        multiplyButton.setBackground(Color.cyan);
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 16));

        divideButton = new JButton("/");
        divideButton.setBackground(Color.cyan);
        divideButton.setFont(new Font("Arial", Font.BOLD, 16));

        poly1TextField = new JTextField();
        poly2TextField = new JTextField();

        poly3TextField = new JTextField();
        //poly3TextField.setEditable(false);
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



    private void editareP1()
    {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String op = ((JButton) e.getSource()).getText();
        Polinom rezultat = new Polinom();

        try{
            if(op.equals("+")){
                rezultat = operatii.adunare(operatii.parsarePolinom(poly1TextField.getText()), operatii.parsarePolinom(poly2TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }

            if(op.equals("-")){
                rezultat = operatii.scadere(operatii.parsarePolinom(poly1TextField.getText()), operatii.parsarePolinom(poly2TextField.getText()));
                poly3TextField.setText(operatii.toString(rezultat));
            }


        } catch (PolinomIntrareGresit ex) {
            throw new RuntimeException(ex);
        }


    }

    }