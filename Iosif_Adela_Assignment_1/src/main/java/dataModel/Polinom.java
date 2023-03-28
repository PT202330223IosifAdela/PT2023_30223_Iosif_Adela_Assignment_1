package dataModel;
import java.util.*;


public class Polinom {

    private Map<Integer, Monom> monoame;    //grad monom-cheie, monom

    public Polinom() {
        this.monoame = new HashMap<>();
    }

    public Polinom(Map<Integer, Monom> m)
    {
        this.monoame = m;
    }

    public Map<Integer, Monom> getMonoame() {
        return monoame;
    }

    public void setMonoame(Map<Integer, Monom> monoame) {
        this.monoame = monoame;
    }


}
