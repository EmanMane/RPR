package ba.unsa.etf.rpr;

import java.util.List;

// KolekcijaImena.java

public class KolekcijaImena {
    private List<String> imena;

    public KolekcijaImena(List<String> imena) {
        this.imena = imena;
    }

    public String getNajduzeIme() {
        String najduzeIme = "";
        for (String ime : imena) {
            if (ime.length() > najduzeIme.length()) {
                najduzeIme = ime;
            }
        }
        return najduzeIme;
    }
}
