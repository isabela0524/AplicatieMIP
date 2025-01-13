package Interfaces;

import Models.Produs;

import java.util.List;

public interface IGestionare {
    void adaugaProdus(Produs produs);
    void stergeProdus(String denumire);
    List<Produs> getProduse();
}
