package ba.unsa.etf.rpr.tutorijal_3;

public class FiksniBroj extends TelefonskiBroj implements Comparable {
    public enum Grad {BIHAC, ORASJE, TUZLA, ZENICA, GORAZDE, TRAVNIK, MOSTAR, SIROKI_BRIJEG, SARAJEVO, LIVNO, BRCKO;}
    private Grad grad;
    private String broj;
    private static String[] pozivni = { "037", "031", "035", "032", "038", "030", "036", "039", "033", "034", "049"};

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    public final String ispisi () {
        return pozivni[grad.ordinal()] + "/" + broj;
    }

    public final String dajPozivniGrada (Grad g) {
        return pozivni[g.ordinal()];
    }

    public final String dajPozivniBroja () {
        return pozivni[grad.ordinal()];
    }
    public final int hashCode () {
        return broj.hashCode();
    }

    @Override
    public final int compareTo (Object o) {
        FiksniBroj fb = (FiksniBroj) o;
        return ispisi().compareTo(fb.ispisi());
    }
}
