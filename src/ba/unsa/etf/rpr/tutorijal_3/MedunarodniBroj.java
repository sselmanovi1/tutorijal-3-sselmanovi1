package ba.unsa.etf.rpr.tutorijal_3;

public class MedunarodniBroj extends TelefonskiBroj implements Comparable{
    private String drzava;
    private String broj;
    public MedunarodniBroj(String drzava,String broj){
        this.drzava=drzava;
        this.broj=broj;
    }
    public final String ispisi () {
        return drzava + "/" + broj;
    }

    public final int hashCode () {
        return broj.hashCode();
    }

    @Override
    public final int compareTo (Object o) {
        MedunarodniBroj mb = (MedunarodniBroj) o;
        return ispisi().compareTo(mb.ispisi());
    }

}

