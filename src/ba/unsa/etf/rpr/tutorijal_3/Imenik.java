package ba.unsa.etf.rpr.tutorijal_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Imenik {
   //public enum Grad {BIHAC, ORASJE, TUZLA, ZENICA, GORAZDE, TRAVNIK, MOSTAR, SIROKI_BRIJEG, SARAJEVO, LIVNO, BRCKO;}
    private HashMap<String, TelefonskiBroj> imenik = new HashMap<String, TelefonskiBroj> ();

    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put (ime, broj);
    }

    public final String dajBroj(String ime) {
        return imenik.get(ime).ispisi();
    }

    public final String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> ulaz : imenik.entrySet()) {
            if (ulaz.getValue() == broj) {
                return ulaz.getKey();
            }
        }
        return "Ne postoji korisnik s tim brojem";
    }

    public final String naSlovo(char s) {
        String str = "";
        int i = 1;
        for (Map.Entry<String, TelefonskiBroj> ulaz : imenik.entrySet()) {
            if ((ulaz.getKey()).charAt(0) == s) {
                str = str + i + ". " + ulaz.getKey() + " - " + ulaz.getValue().ispisi() + "\n";
                i++;
            }
        }
        return str;
    }

    public final Set<String> izGrada(FiksniBroj.Grad g) {
        Set<String> s = new HashSet<>();
        for (Map.Entry<String, TelefonskiBroj> ulaz : imenik.entrySet()) {
            TelefonskiBroj br = ulaz.getValue();
            if (br instanceof FiksniBroj) {
                FiksniBroj broj = (FiksniBroj) br;
                if (broj.dajPozivniBroja().equals(broj.dajPozivniGrada(g))) {
                    s.add(ulaz.getKey());
                }
            }
        }
        List<String> lista = new ArrayList<String>(s);
        Collections.sort(lista);
        return s;
    }

    public final Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        Set<TelefonskiBroj> s = new HashSet<>();
        for (Map.Entry<String, TelefonskiBroj> ulaz : imenik.entrySet()) {
            TelefonskiBroj br = ulaz.getValue();
            if (br instanceof FiksniBroj) {
                FiksniBroj broj = (FiksniBroj) br;
                if (broj.dajPozivniBroja().equals(broj.dajPozivniGrada(g))) {
                    s.add(ulaz.getValue());
                }
            }
        }
        TreeSet<TelefonskiBroj> sortirano = new TreeSet();
        sortirano.addAll (s);
        return sortirano;
    }
}