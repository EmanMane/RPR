package ba.unsa.etf.rpr;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Specify the XML file
        File xmlFile = new File("laptops.xml");

        // Create a LaptopDaoXMLFile instance
        LaptopDaoXMLFile xmlDao = new LaptopDaoXMLFile(xmlFile);

        // Create a Laptop
        Laptop laptop1 = new Laptop("HP", "Pavilion", 1200.0, 8, 1000, 256, "Intel i5", "Nvidia GTX 1650", 15.6);

        // Add the Laptop to the XML file
        xmlDao.dodajLaptopUFile(laptop1);

        // Retrieve laptops from the XML file
        ArrayList<Laptop> laptopsFromXml = xmlDao.vratiPodatkeIzDatoteke();

        // Display retrieved laptops
        System.out.println("Laptopi iz datoteke:");
        for (Laptop laptop : laptopsFromXml) {
            System.out.println(laptop);
        }

        // Search for a laptop by processor
        try {
            Laptop foundLaptop = xmlDao.getLaptop("Intel i5");
            System.out.println("\nPronađeni laptop:\n" + foundLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }
    }
}
