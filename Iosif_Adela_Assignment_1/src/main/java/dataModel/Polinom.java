package dataModel;
import java.security.Key;
import java.util.*;


public class Polinom {

    private Map<Cheie, Monom> mapPoli;
    public Polinom() {
        mapPoli = new HashMap<>();
    }

    public Polinom(String polinomDat) {

        mapPoli = new HashMap<>();
        String[] sirMonoame = polinomDat.split("\\s*\\+\\s*|\\s*-\\s*");
        for(String m: sirMonoame){
            Monom monom = new Monom(m);
            addMonom(monom);
        }
    }

    public void addMonom(Monom monom) {  //adauga un monom la map (la polinom)
        Cheie key = new Cheie(monom.getCoef(), monom.getExp());

        if (mapPoli.containsKey(key)) {
            Monom monomExista = mapPoli.get(key);
            monomExista.setCoef(monomExista.getCoef() + monom.getCoef());

            if(monomExista.getCoef() == 0){
                mapPoli.remove(key);
            }
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

    @Override
    public String toString() {
        List<Cheie> c = new ArrayList<>(mapPoli.keySet());
        c.sort(Comparator.comparingInt(Cheie::getExp).reversed());

        StringBuilder s = new StringBuilder();

        /*for(Map.Entry<Cheie, Monom> entry: mapPoli.entrySet()){
            Monom monom = entry.getValue();
            s.append(monom.toString());
            s.append("+");
        }
        //se scad caracterele "+"
        s.setLength(s.length() - 1);*/

        for(Cheie ch: c){
            Monom monom = mapPoli.get(ch);
            if(monom.getCoef() == 0){
                continue;
            }
           // if(s.length() > 0){
            //    s.append("+");
            //}
            if(monom.getCoef() >= 0 ){
                s.append("+");
            }
            else {
                s.append("-");
            }
            s.append(Math.abs(monom.getCoef()));
            s.append("x^");
            s.append(ch.getExp());
        }
        return s.toString();
    }
}
