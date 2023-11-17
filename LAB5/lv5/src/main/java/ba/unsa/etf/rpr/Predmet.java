package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

// Predmet.java

public class Predmet {
    private String naziv;
    private String opis;
    private List<Ocjena> ocjene;

    public Predmet() {
        this.ocjene = new ArrayList<>();
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }

    public void dodajOcjenu(MozeOcijeniti osoba, int ocjena) {
        Ocjena novaOcjena = osoba.ocijeni(ocjena);
        ocjene.add(novaOcjena);
    }


    // Getteri i setteri za naziv
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    // Getteri i setteri za opis
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
