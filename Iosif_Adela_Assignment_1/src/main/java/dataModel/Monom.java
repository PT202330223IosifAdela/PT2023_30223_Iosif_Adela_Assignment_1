package dataModel;

import java.util.*;

public class Monom {
    //declarare campuri pt coeficient si exponent monom, incapsulate
    private float coef;
    private int exp;

    //constructor
    public Monom(float coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    //getteri si setteri
    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
