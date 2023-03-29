package operatii;

import dataModel.Monom;
import dataModel.Polinom;
import dataModel.PolinomIntrareGresit;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {
    public Polinom adunare(Polinom a, Polinom b) {
        Polinom polinomRez = new Polinom();

        //grad monom-cheie; monom-valoare
        for (Map.Entry<Integer, Monom> entry: a.getMonoame().entrySet()) {
            Monom m = entry.getValue();
            Integer putere = entry.getKey();
            Monom existent = b.getMonoame().get(putere);

            if(existent != null){
                float coef = m.getCoef() + existent.getCoef();
                Monom rezMonom = new Monom(coef, putere);
                polinomRez.getMonoame().put(putere, rezMonom);
                b.getMonoame().remove(putere);
            }
            else{
                polinomRez.getMonoame().put(putere, m);
            }
        }
        for(Map.Entry<Integer, Monom> entry: b.getMonoame().entrySet()){
            Monom m =entry.getValue();
            Integer putere = entry.getKey();
            polinomRez.getMonoame().put(putere, m);
        }
    //sortare dupa grad - to de
        return polinomRez;
    }

    public Polinom scadere(Polinom a, Polinom b) {
        Polinom polinomRez = new Polinom();

        //grad monom-cheie; monom-valoare
        for (Map.Entry<Integer, Monom> entry: a.getMonoame().entrySet()) {
            Monom m = entry.getValue();
            Integer putere = entry.getKey();
            Monom existent = b.getMonoame().get(putere);

            if(existent != null) {
                float coef = m.getCoef() - existent.getCoef();
                Monom rezMonom = new Monom(coef, putere);

                if (rezMonom.getCoef() != 0) {
                    polinomRez.getMonoame().put(putere, rezMonom);
                }
                b.getMonoame().remove(putere);
            }
            else{
                polinomRez.getMonoame().put(putere, m);
            }
        }
        for(Map.Entry<Integer, Monom> entry: b.getMonoame().entrySet()){
            Monom m =entry.getValue();
            Integer putere = entry.getKey();
            Monom rezMonon = new Monom((-1) * m.getCoef(), putere);
            polinomRez.getMonoame().put(putere, rezMonon);
        }
        //sortare dupa grad - to do
        return polinomRez;
    }

   public Polinom derivare(Polinom a) {
        Polinom rez = new Polinom();

       for(Map.Entry<Integer, Monom> entry: a.getMonoame().entrySet()){
           Integer putere = entry.getKey();
           float coef = entry.getValue().getCoef();
           Monom rezMonon = new Monom(coef * putere, putere - 1);
           rez.getMonoame().put(putere - 1, rezMonon);
       }
        return rez;
    }

    public String toString(Polinom polinom){
        String rezultat = "";

        for (Map.Entry<Integer, Monom> entry : polinom.getMonoame().entrySet()) {
            float coef = entry.getValue().getCoef();
            int putere = entry.getKey();

            //pt coeficienti pozitivi
            if (coef > 0 && !rezultat.equals("")) {
                rezultat = rezultat + "+";
            }

            if (coef != 0) {
                if (Math.ceil(coef) == coef) {//coef e practic intreg
                    if (coef != 1) {
                        if (coef != -1) {
                            rezultat = rezultat + (int) coef;//nu mai punem 0 degeaba
                        } else {
                            rezultat = rezultat + "-";  //coef negativ diferit de -1
                        }
                    }
                } else {   //coef pozitivi diferiti de 1
                    rezultat = rezultat + String.format("%.02f", coef); //2 zecimale
                }
                if (putere != 0) {
                    rezultat = rezultat + "x";
                    if (putere != 1) {
                        rezultat = rezultat + "^";  //x^1=x; punem puterea doar daca e dif de 1
                        rezultat = rezultat + putere;
                    }
                }
            }
        }
        if(rezultat.equals("")){
            return "0";
        }
        else{
            return rezultat;
        }
    }

    public Polinom parsarePolinom(String polinom) throws PolinomIntrareGresit{
        Polinom rez = new Polinom();
        if (Objects.equals(polinom, "")) {//textbox gol, nu s-au introdus polinoame
            throw new PolinomIntrareGresit("Nu ati introdus date");
        }
        String pattern = "((\\+|\\-|^)(\\d*))x{0,1}(\\^\\-{0,1}(\\d+))*";
       // String pattern ="((\\+|\\-|^)(\\d*\\.?\\d+|\\.\\d+))x{0,1}(\\^\\-{0,1}(\\d+))*";

        Pattern p = Pattern.compile(pattern);

        StringBuilder matcher = new StringBuilder();
        Matcher m = p.matcher(polinom);

        while (m.find()) {
            matcher.append(m.group(0));//fiecare cuv pe linie noua //0
            String coef = m.group(1); //1
            String putere = m.group(5);//5

            float coefParsat = 1.0F;

            if (coef != null && !coef.equals("")) {
                if (!(coef.equals("+") || coef.equals("-"))) {
                    coefParsat = Float.parseFloat(coef);//nu are semn in fata
                } else {
                    if (coef.equals("-"))//coef negativ
                    {
                        coefParsat = (float) -1.0;
                    }
                }
                //daca e pozitiv, coef ramane 1
            }

            int putereParsata = 1;
            if (putere != null && !putere.equals("")) {
                putereParsata = Integer.parseInt(putere);
            } else {
                if (!m.group(0).contains("x")) {
                    putereParsata = 0;
                }
            }
            Monom monomNou = new Monom(coefParsat, putereParsata);
            if (coefParsat != 0) {
                Monom existent = rez.getMonoame().get(putereParsata);

                if (existent == null) {
                    rez.getMonoame().put(putereParsata, monomNou);
                } else {
                    //avem in acelasi polinom, monoame de acelasi grad => aduna coeficientii: 2x+x=3x
                    existent.setCoef(existent.getCoef() + coefParsat);
                }
            }
        }
        if(!polinom.equals(matcher.toString())){
            throw new PolinomIntrareGresit("Polinom introdus gresit.");
        }
    return rez;
    }

}