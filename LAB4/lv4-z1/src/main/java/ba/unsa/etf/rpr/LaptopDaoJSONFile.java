package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private final File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the existing laptops from the file
            ArrayList<Laptop> existingLaptops = laptopi;

            // Add the new laptop to the list
            existingLaptops.add(laptop);

            // Write the entire list back to the file, including square brackets
            try (FileWriter fileWriter = new FileWriter(file)) {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, existingLaptops);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            laptopi = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));

            for (Laptop laptop : laptopi) {
                if (laptop.getProcesor().equals(procesor)) {
                    return laptop;
                }
            }

            throw new NeodgovarajuciProcesorException("Laptop sa procesorom " + procesor + " nije pronađen.");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
