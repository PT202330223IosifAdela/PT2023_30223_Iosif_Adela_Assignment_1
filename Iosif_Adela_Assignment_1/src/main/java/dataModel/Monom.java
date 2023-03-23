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
