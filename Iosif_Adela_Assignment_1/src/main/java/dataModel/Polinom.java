package dataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Polinom {

    private Map<Cheie, Monom> mapPoli;

    public Polinom() {
        mapPoli = new HashMap<>();
    }

    public void addMonom(Monom monom) {  //adauga un monom la map (la polinom)
        Cheie key = new Cheie(monom.getCoef(), monom.getExp());

        if (mapPoli.containsKey(key)) {
            Monom monomExista = mapPoli.get(key);
            monomExista.setCoef(monomExista.getCoef() + monom.getCoef());
        } else {
            mapPoli.put(key, monom);
        }
    }

    public void removeMonom(Monom monom) {   //eliminare monom din map (din polinom)
        Cheie key = new Cheie(monom.getCoef(), monom.getExp());
        if (mapPoli.containsKey(key)) {//daca exista monom cu acelasi exponent, se scad coeficientii
            Monom monomExista = mapPoli.get(key);
            monomExista.setCoef(monomExista.getCoef() - monom.getCoef());

            if(monomExista.getCoef() == 0){ //coeficientul monomului e zero, se sterge monomul
                mapPoli.remove(key);
            }
        } else {//monom de grad care nu mai exista, se scade din map
            mapPoli.put(key, new Monom(-monom.getCoef(), monom.getExp()));
        }
    }

    public List<Monom> getMonoame() {
        List<Monom> monoame = new ArrayList<>();
        for (Monom m : mapPoli.values()) {
            monoame.add(m);
        }
        return monoame;
    }
}
