package ba.unsa.etf.rpr;

// Pobjednik.java

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;

    public Pobjednik(KolekcijaImena kolekcijaImena) {
        String najduzeIme = kolekcijaImena.getNajduzeIme();
        String[] parts = najduzeIme.split(" ");
        this.ime = parts[0];
        this.prezime = parts[1];
        this.brojZnakova = najduzeIme.length();
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }
}