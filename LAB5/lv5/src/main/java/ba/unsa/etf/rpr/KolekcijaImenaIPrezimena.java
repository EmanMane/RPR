package ba.unsa.etf.rpr;

import java.util.List;

// KolekcijaImenaIPrezimena.java

public class KolekcijaImenaIPrezimena {
    private List<String> imena;
    private List<String> prezimena;

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }

    public int getIndexNajduzegPara() {
        int index = 0;
        int maxDuzina = 0;

        for (int i = 0; i < imena.size(); i++) {
            String imePrezime = imena.get(i) + prezimena.get(i);
            if (imePrezime.length() > maxDuzina) {
                maxDuzina = imePrezime.length();
                index = i;
            }
        }
        return index;
    }

    public String getImeiPrezime(int i) {
        return imena.get(i) + " " + prezimena.get(i);
    }
}
