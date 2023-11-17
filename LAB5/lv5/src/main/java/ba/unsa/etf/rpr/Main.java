package ba.unsa.etf.rpr;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Primjer korištenja KolekcijaImena
        List<String> imena = Arrays.asList("Ana", "Marko", "Emanuella");
        KolekcijaImena kolekcijaImena = new KolekcijaImena(imena);
        System.out.println("Najduze ime: " + kolekcijaImena.getNajduzeIme());

        // Primjer korištenja Pobjednik
        List<String> imenaPobjednik = Arrays.asList("John Doe", "Jane Smith", "Alice Johnson");
        KolekcijaImena kolekcijaImenaPobjednik = new KolekcijaImena(imenaPobjednik);
        Pobjednik pobjednik = new Pobjednik(kolekcijaImenaPobjednik);
        System.out.println("Pobjednik: " + pobjednik.getIme() + " " + pobjednik.getPrezime());

        // Primjer korištenja KolekcijaImenaIPrezimena
        List<String> imenaIPrezimena = Arrays.asList("John", "Ankica", "Alice");
        List<String> prezimenaIPrezimena = Arrays.asList("Doe", "Hadzihodzic", "Johnson");
        KolekcijaImenaIPrezimena kolekcijaImenaIPrezimena = new KolekcijaImenaIPrezimena(imenaIPrezimena, prezimenaIPrezimena);
        int indexNajduzegPara = kolekcijaImenaIPrezimena.getIndexNajduzegPara();
        System.out.println("Najduzi par: " + kolekcijaImenaIPrezimena.getImeiPrezime(indexNajduzegPara));

        // Primjer korištenja ocjena
        InformacijeOStudentu student = new InformacijeOStudentu();
        student.setIme("Jane");
        student.setPrezime("Doe");
        student.setGodinaStudija("2");
        student.setBrojIndexa("123456");

        Predmet matematika = new Predmet();
        matematika.setNaziv("Matematika");
        matematika.setOpis("Opći uvod u matematiku");
        matematika.dodajOcjenu(student, 8);

        InformacijeONastavniku nastavnik = new InformacijeONastavniku();
        nastavnik.setIme("Professor");
        nastavnik.setPrezime("Smith");
        nastavnik.setTitula("Dr.");
        nastavnik.ocijeni(9);

        // Ispis ocjena
        System.out.println("Ocjene za predmet Matematika:");
        for (Ocjena ocjena : matematika.getOcjene()) {
            System.out.println(ocjena.getOcjena() + " - " + ocjena.getOsoba().getIme() + " " + ocjena.getOsoba().getPrezime());
        }

        System.out.println("Ocjene za nastavnika Professor Smith:");
        for (Ocjena ocjena : nastavnik.getOcjene()) {
            System.out.println(ocjena.getOcjena() + " - " + ocjena.getOsoba().getIme() + " " + ocjena.getOsoba().getPrezime());
        }
    }
}
