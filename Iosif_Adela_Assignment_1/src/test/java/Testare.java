import org.junit.Test;
import dataModel.Polinom;
import org.junit.Assert;
import operatii.Operatii;
import dataModel.PolinomIntrareGresit;
import dataModel.Polinom;

import javax.swing.*;

public class Testare {
    private final Operatii operatii = new Operatii();

    @Test
    public void adunareTest() {
        String s1 = "x^2+2x^0";
        String s2 = "7x^3+6x";
        Polinom rezultat;
        try {
            rezultat = operatii.adunare(operatii.parsarePolinom(s1), operatii.parsarePolinom(s2));
            Assert.assertEquals("2+6x+x^2+7x^3", operatii.toString(rezultat));

        } catch (PolinomIntrareGresit ex) {
            JOptionPane.showMessageDialog(null, "Nu coincide rez", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Test
    public void scadereTest() {
        String s1 = "x^2+2x^0";
        String s2 = "7x^3+6x";
        Polinom rezultat;
        try {
            rezultat = operatii.scadere(operatii.parsarePolinom(s1), operatii.parsarePolinom(s2));
            Assert.assertEquals("2-6x+x^2-7x^3", operatii.toString(rezultat));
        } catch (PolinomIntrareGresit ex) {
            JOptionPane.showMessageDialog(null, "Nu coincide rez", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Test
    public void inmultireTest() {
        String s1 = "x^2+2x^0";
        String s2 = "7x^3+6x";

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom rezultat;
        try {
            rezultat = operatii.inmultire(operatii.parsarePolinom(s1), operatii.parsarePolinom(s2));
            Assert.assertEquals("12x+20x^3+7x^5", operatii.toString(rezultat));
        } catch (PolinomIntrareGresit ex) {
            JOptionPane.showMessageDialog(null, "Nu coincide rez", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Test
    public void derivareTest() {
        String s1 = "x^2+2x^0";
        Polinom rezultat;
        try {
            rezultat = operatii.derivare(operatii.parsarePolinom(s1));
            Assert.assertEquals("2x", operatii.toString(rezultat));
        } catch (PolinomIntrareGresit ex) {
            JOptionPane.showMessageDialog(null, "Nu coincide rez", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Test
    public void integrareTest() {
        String s1 = "x^2+2x^0";
        Polinom rezultat;
        try {
            rezultat = operatii.integrare(operatii.parsarePolinom(s1));
            Assert.assertEquals("2x+0,33x^3", operatii.toString(rezultat));
        } catch (PolinomIntrareGresit ex) {
            JOptionPane.showMessageDialog(null, "Nu coincide rez", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
