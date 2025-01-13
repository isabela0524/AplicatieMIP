package Models;

import Interfaces.IPersistenta;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PersistentaTXT implements IPersistenta {
    private final String fisier = "produse.txt";

    @Override
    public void salvareDate(List<Produs> produse) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fisier))) {
            for (Produs produs : produse) {
                String linie = produs.getDenumire() + "," + produs.getPret();
                if (produs instanceof ProdusDiscount) {
                    linie += "," + ((ProdusDiscount) produs).getPretFinal();
                }
                writer.write(linie);
                writer.newLine();

            }
            System.out.println("Datele au fost salvate in fisierul txt. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produs> incarcaDate() {
        List<Produs> produse = new ArrayList<>();
        try {
            List<String> linii = Files.readAllLines(Paths.get(fisier));
            for (String line : linii) {
                String[] dateProdus = line.split(",");
                String denumire = dateProdus[0];
                double prest = Double.parseDouble(dateProdus[1]);

                if (dateProdus.length == 3) {
                    double discount = Double.parseDouble(dateProdus[2]);
                    produse.add(new ProdusDiscount(denumire, prest, discount));
                } else {
                    produse.add(new ProdusNormal(denumire, prest));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produse;
    }
}
