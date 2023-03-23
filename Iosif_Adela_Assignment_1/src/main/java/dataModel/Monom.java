package dataModel;
import java.util.*;
public class Monom {
    //declarare campuri pt coeficient si exponent polinom, incapsulate
    private int coef;
    private int exp;

    //constructor
    public Monom(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public Monom(String monom){
        //se elimina spatiile albe din monomul dat
        monom = monom.replaceAll("\\s+","");

        //verificam daca string-ul il contine pe x
        if(!monom.contains("x")){
            coef = Integer.parseInt(monom);
            exp = 0;
            return;
        }
        //se imparte sirul cu x
        String[] p = monom.split("x");
    //identificam cum e coeficientul
        if(p[0].equals("-")){
            coef = -1;
        }
        else if(p[0].equals("") || p[0].equals("+")){
            coef = 1;
        }
        else {
            coef = Integer.parseInt(p[0]);
        }
        //exponent
        if(p.length == 1){
            exp = 1;
        }
        else{
            String exponentString = p[1].substring(1);
            exp = Integer.parseInt(exponentString);
        }
    }


    //getteri si setteri
    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
            return coef +"x^" + exp + " ";
    }

    public Monom adunare(Monom monomNou){
        if(this.getExp() != monomNou.getExp()){
            throw new IllegalArgumentException("Exponentii trebuie sa aiba acelasi grad!");

        }
        int coefNou = this.getCoef() + monomNou.getCoef();
        return new Monom(coefNou, this.exp);
    }

    public Monom scadere(Monom monomNou){
        if(this.getExp() != monomNou.getExp()){
            throw new IllegalArgumentException("Exponentii trebuie sa aiba acelasi grad!");

        }
        int coefNou = this.getCoef() - monomNou.getCoef();
        return new Monom(coefNou, this.exp);
    }

    public Monom inmultire(Monom monomNou){
        int coefNou = this.getCoef() * monomNou.getCoef();
        int expNou = this.getExp() + monomNou.getExp();
        return new Monom(coefNou, expNou);
    }

}
