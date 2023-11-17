package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private final File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println("Brend: " + laptop.getBrend());
            writer.println("Model: " + laptop.getModel());
            writer.println("Cijena: " + laptop.getCijena());
            writer.println("Ram: " + laptop.getRam());
            writer.println("HDD: " + laptop.getHdd());
            writer.println("SSD: " + laptop.getSsd());
            writer.println("Procesor: " + laptop.getProcesor());
            writer.println("Grafička kartica: " + laptop.getGrafickaKartica());
            writer.println("Veličina ekrana: " + laptop.getVelicinaEkrana());
            writer.println();  // Add an empty line between laptops
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Laptop sa procesorom " + procesor + " nije pronadjen.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> rezultat = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Laptop laptop = new Laptop();
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    // Empty line indicates the end of a laptop entry
                    rezultat.add(laptop);
                    laptop = new Laptop(); // Create a new Laptop object for the next entry
                } else {
                    // Parse each line and set the corresponding attribute in the Laptop object
                    String[] parts = line.split(": ");
                    String attribute = parts[0].trim();
                    String value = parts[1].trim();
                    
                    switch (attribute) {
                        case "Brend":
                            laptop.setBrend(value);
                            break;
                        case "Model":
                            laptop.setModel(value);
                            break;
                        case "Cijena":
                            laptop.setCijena(Double.parseDouble(value));
                            break;
                        case "Ram":
                            laptop.setRam(Integer.parseInt(value));
                            break;
                        case "HDD":
                            laptop.setHdd(Integer.parseInt(value));
                            break;
                        case "SSD":
                            laptop.setSsd(Integer.parseInt(value));
                            break;
                        case "Procesor":
                            laptop.setProcesor(value);
                            break;
                        case "Grafička kartica":
                            laptop.setGrafickaKartica(value);
                            break;
                        case "Veličina ekrana":
                            laptop.setVelicinaEkrana(Double.parseDouble(value));
                            break;
                        default:
                            // Handle unknown attribute
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    
}
