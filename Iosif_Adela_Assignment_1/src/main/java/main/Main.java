package main;

import dataModel.Monom;
import dataModel.Polinom;
import interfata.Interfata;
import operatii.Operatii;

public class Main {
    public static void main(String[] args) {

        Interfata calculator = new Interfata();
        Monom m1 = new Monom(4, 3);
        Monom m2 = new Monom(7, 3);
        Monom m3 = m1.adunare(m2);
        Monom m4 = m1.scadere(m2);
        System.out.println(m1 + " + " + m2 + " = " + m3);
        System.out.println(m1 + " - " + m2 + " = " + m4);

       /* Polinom p1 = new Polinom("x^2 + 9x + 1");
        Polinom p2 = new Polinom("2x^3 - 4x^2 + 2");
        Polinom p3 = Operatii.adunare(p1, p2);
        Polinom p4 = Operatii.scadere(p1, p2);
        System.out.println(p3);
        System.out.println(p4);*/
    }
}