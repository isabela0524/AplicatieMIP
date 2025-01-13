package Models;

public class ProdusDiscount extends Produs{
    private double discount;
    public ProdusDiscount(String denumire, double pret, double discount) {
        super(denumire, pret);
        this.discount = discount;
    }
    @Override
    public void afiseazaDetalii(){
        System.out.println("Produs discount: "+getDenumire()+", Pret initial: "+getPret()+", Discount: "+discount+"%");
    }
    public double getPretFinal(){
        return getPret()*(1-discount/100);
    }
}
