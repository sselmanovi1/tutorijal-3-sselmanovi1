package ba.unsa.etf.rpr.tutorijal_3;

public class MobilniBroj extends TelefonskiBroj implements Comparable {
    private int mobilnamreza;
    private String broj;
     public MobilniBroj(int mobilnamreza,String broj){
         this.mobilnamreza=mobilnamreza;
         this.broj=broj;
     }
    public final String ispisi () {
        return "0" + mobilnamreza + "/" + broj;
    }
    public final int hashCode(){
         return broj.hashCode();
    }
    @Override
    public final int compareTo(Object o){
         MobilniBroj mb=(MobilniBroj)o;
         return ispisi().compareTo(mb.ispisi());

    }
}
