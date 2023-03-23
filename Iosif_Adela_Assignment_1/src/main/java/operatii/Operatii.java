package operatii;

import dataModel.Monom;
import dataModel.Polinom;

public class Operatii {
    public static Polinom adunare(Polinom a, Polinom b) {
        Polinom rezultat = new Polinom();

        for (Monom monom1 : a.getMonoame()) {
                rezultat.addMonom(monom1);
        }
        for(Monom monom2: b.getMonoame()){
            rezultat.addMonom(monom2);
        }
        return rezultat;
    }
    public static Polinom scadere(Polinom a, Polinom b) {
        Polinom rezultat = new Polinom();

        for (Monom monom1 : a.getMonoame()) {
            rezultat.removeMonom(monom1);
        }
        for(Monom monom2: b.getMonoame()){
            rezultat.removeMonom(monom2);
        }
        return rezultat;
    }

}