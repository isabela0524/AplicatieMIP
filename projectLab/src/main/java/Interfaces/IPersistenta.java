package Interfaces;

import Models.Produs;

import java.util.List;

public interface IPersistenta {
    void salvareDate(List<Produs>produse);
    List<Produs>incarcaDate();
}
