package org.example;

import Interfaces.IGestionare;
import Interfaces.IPersistenta;
import Models.*;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IPersistenta managerPersistenta=new PersistentaTXT();
        IGestionare managerProduse= new ManagerProduse();

        List<Produs> produse=managerPersistenta.incarcaDate();
        for(Produs produs:produse){
            managerProduse.adaugaProdus(produs);
        }

        boolean running=true;
        while(running){
            System.out.println("\n1. Adauga produs");
            System.out.println("2. Afiseaza produse");
            System.out.println("3. Sterge produs");
            System.out.println("4. Salveaza produse");
            System.out.println("5. Iesire");
            System.out.println("Alege o optiune: ");
            int op=0;
            try{
                op=sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Te rog introdu un numar valid!");
                sc.nextLine();
                continue;
            }

            switch(op){
                case 1:
                    System.out.println("Introduceti denumirea produsului: ");
                    String denumire=sc.nextLine();
                    System.out.println("Introduceti pretul produsului: ");
                    double pret=sc.nextDouble();
                    System.out.println("Introduceti tipul produsului (normal/discount): ");
                    String tip=sc.next().toLowerCase();
                    if(tip.equals("discount")){
                        System.out.println("Introduceti discount-ul: ");
                        double discount=sc.nextDouble();
                        managerProduse.adaugaProdus(new ProdusDiscount(denumire, pret, discount));
                    }
                    else {
                        managerProduse.adaugaProdus(new ProdusNormal(denumire, pret));
                    }
                    break;
                    case 2:
                        System.out.println("Produse: ");
                        for(Produs produs: managerProduse.getProduse()){
                            produs.afiseazaDetalii();
                        }
                        break;
                        case 3:
                            System.out.println("Introduceti denumirea produsului de sters: ");
                            String denumireStergere=sc.nextLine();
                            managerProduse.stergeProdus(denumireStergere);
                            break;
                            case 4:
                                managerPersistenta.salvareDate(managerProduse.getProduse());
                                break;
                                case 5:
                                    running=false;
                                    System.out.println("La revedere!");
                                    break;
                                    default:
                                        System.out.println("Optiune invalida!");
                                        break;
            }
        }
        sc.close();
    }
}