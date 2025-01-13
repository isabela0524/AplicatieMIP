package Models;

import Interfaces.IGestionare;

import java.util.ArrayList;
import java.util.List;

public class ManagerProduse implements IGestionare {
    private List<Produs>produse=new ArrayList<>();

    @Override
    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }

    @Override
    public void stergeProdus(String denumire){
        produse.removeIf(produs -> produs.getDenumire().equalsIgnoreCase(denumire));
    }

    @Override
    public List<Produs> getProduse() {
        return produse;
    }
}
