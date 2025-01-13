package Models;

public class ProdusNormal extends Produs {
    public ProdusNormal(String denumire, double pret) {
        super(denumire, pret);
    }

    @Override
    public void afiseazaDetalii(){
        System.out.println("Produs normal: "+getDenumire()+ ", Pret: "+getPret());
    }
}
