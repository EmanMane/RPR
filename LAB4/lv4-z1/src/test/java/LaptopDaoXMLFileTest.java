import ba.unsa.etf.rpr.Laptop;
import ba.unsa.etf.rpr.LaptopDaoXMLFile;
import ba.unsa.etf.rpr.NeodgovarajuciProcesorException;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LaptopDaoXMLFileTest {

    private LaptopDaoXMLFile laptopDao;
    private final String testFilePath = "test.xml";

    @BeforeEach
    void setUp() {
        laptopDao = new LaptopDaoXMLFile(new File(testFilePath));
    }

    @AfterEach
    void tearDown() {
        File testFile = new File(testFilePath);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void dodajLaptopUListu() {
        Laptop laptop = new Laptop("Dell", "Inspiron", 950.0, 16, 512, 0, "AMD Ryzen 7", "AMD Radeon Vega", 14.0);

        laptopDao.dodajLaptopUListu(laptop);

        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(0, laptops.size());
    }

    @Test
    void dodajLaptopUFile() {
        Laptop laptop = new Laptop("HP", "Pavilion", 1200.0, 8, 1000, 256, "Intel i5", "Nvidia GTX 1650", 15.6);

        laptopDao.dodajLaptopUFile(laptop);

        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(1, laptops.size());
    }

    @Test
    void getLaptop() {
        Laptop laptop = new Laptop("Dell", "Inspiron", 950.0, 16, 512, 0, "AMD Ryzen 7", "AMD Radeon Vega", 14.0);
        laptopDao.dodajLaptopUFile(laptop);

        try {
            Laptop foundLaptop = laptopDao.getLaptop("AMD Ryzen 7");
            assertEquals(laptop, foundLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            e.printStackTrace();
        }
    }

    @Test
    void napuniListu() {
        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Dell", "Inspiron", 950.0, 16, 512, 0, "AMD Ryzen 7", "AMD Radeon Vega", 14.0));

        laptopDao.napuniListu(laptops);

        assertEquals(0, laptopDao.vratiPodatkeIzDatoteke().size());
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        Laptop laptop1 = new Laptop("Dell", "Inspiron", 950.0, 16, 512, 0, "AMD Ryzen 7", "AMD Radeon Vega", 14.0);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 1200.0, 8, 1000, 256, "Intel i5", "Nvidia GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop1);
        laptopDao.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();

        assertEquals(2, laptops.size());
        assertEquals(laptop1, laptops.get(0));
        assertEquals(laptop2, laptops.get(1));
    }

    // Mock test primjer
    @Test
    void getLaptopWithMock() {
        LaptopDaoXMLFile dao = Mockito.spy(new LaptopDaoXMLFile(new File(testFilePath)));
        Laptop laptop = new Laptop("Dell", "Inspiron", 950.0, 16, 512, 0, "AMD Ryzen 7", "AMD Radeon Vega", 14.0);

        dao.dodajLaptopUFile(laptop);

        try {
            // Mockanje getLaptop metode da vrati laptop bez citanja fajla
            when(dao.getLaptop("AMD Ryzen 7")).thenReturn(laptop);

            Laptop foundLaptop = dao.getLaptop("AMD Ryzen 7");
            assertEquals(laptop, foundLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            e.printStackTrace();
        }
    }
}
