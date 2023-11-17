package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

// KolekcijaPoruka.java

public class KolekcijaPoruka {
    private List<String> poruke;

    public KolekcijaPoruka(List<? extends LicneInformacije> lista) {
        this.poruke = new ArrayList<>();
        for (LicneInformacije info : lista) {
            this.poruke.add(info.getIme() + " " + info.getPrezime());
        }
    }

    public List<String> getPoruke() {
        return poruke;
    }
}
