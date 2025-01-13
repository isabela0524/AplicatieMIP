package Models;

import Interfaces.IProdus;

public class Produs implements IProdus {
    private String denumire;
    private double pret;

    public Produs(String denumire, double pret) {
        this.denumire = denumire;
        this.pret = pret;
    }
    public String getDenumire() {
        return denumire;
    }
    public double getPret() {
        return pret;
    }
    public void afiseazaDetalii(){
        System.out.println("Produs: " + denumire + ", Pret: " + pret);
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire=" + denumire + '\''+
                 " pret=" + pret + '}';
    }
}
