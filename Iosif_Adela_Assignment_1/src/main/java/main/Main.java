package main;

import dataModel.Monom;
import interfata.Interfata;

public class Main {
    public static void main(String[] args) {

        //Interfata calculator = new Interfata();
        Monom m1 = new Monom(0, 3);
        Monom m2 = new Monom(0, 3);
        Monom m3 = m1.adunare(m2);
        Monom m4 = m1.scadere(m2);
        System.out.println(m1 + " + " + m2 + " = " + m3);
        System.out.println(m1 + " - " + m2 + " = " + m4);
    }
}