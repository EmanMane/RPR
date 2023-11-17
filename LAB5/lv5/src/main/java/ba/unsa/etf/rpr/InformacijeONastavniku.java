package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

// InformacijeONastavniku.java

public class InformacijeONastavniku extends LicneInformacije implements MozeOcijeniti {
    private String titula;
    private List<Ocjena> ocjene;

    public InformacijeONastavniku() {
        this.ocjene = new ArrayList<>();
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    @Override
    public Ocjena ocijeni(int x) {
        Ocjena novaOcjena = new Ocjena(this, x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }
}
