package dataModel;

import java.util.Objects;

public class Cheie {
    private int coef;
    private int exp;

    public Cheie(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheie cheie = (Cheie) o;
        return coef == cheie.coef && exp == cheie.exp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coef, exp);
    }

    public int getExp() {
        return exp;
    }
}
