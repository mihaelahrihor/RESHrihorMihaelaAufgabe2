package controller;

import model.Charakter;
import model.Produkt;
import view.MarvelView;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MarvelController {
    private List<Charakter> charaktere;
    private List<Produkt> produkte;
    private MarvelView view;

    public MarvelController(List<Produkt> produkte, List<Charakter> charaktere) {
        this.produkte = produkte;
        this.charaktere = charaktere;
        this.view = new MarvelView();
        initialisiereDaten();
    }

    private void initialisiereDaten() {
        // Produkte initialisieren
        produkte.add(new Produkt("Mjolnir", 500.0, "Asgard"));
        produkte.add(new Produkt("Norn Stones", 1200.0, "Asgard"));
        produkte.add(new Produkt("Darkhold", 2000.0, "Multiverse"));

        // Charaktere initialisieren
        Charakter thor = new Charakter(1, "Thor", "Asgard");
        thor.kaufeProdukt(produkte.get(0)); // Mjolnir
        thor.kaufeProdukt(produkte.get(1)); // Norn Stones
        thor.kaufeProdukt(produkte.get(2)); // Darkhold

        charaktere.add(thor);
    }

    public void zeigeAlleCharaktere() {
        view.zeigeCharaktere(charaktere);
    }

    public void zeigeAlleProdukte() {
        view.zeigeProdukte(produkte);
    }

    public void zeigeProdukteEinesCharakters(String name) {
        for (Charakter c : charaktere) {
            if (c.getName().equalsIgnoreCase(name)) {
                view.zeigeProdukteEinesCharakters(c);
                return;
            }
        }
        System.out.println("Charakter nicht gefunden!");
    }

    public void sortiereProdukteEinesCharakters(String name, boolean aufsteigend) {
        for (Charakter c : charaktere) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<Produkt> sortierteProdukte = c.getGekaufteProdukte()
                        .stream()
                        .sorted(aufsteigend ? Comparator.comparing(Produkt::getPreis)
                                : Comparator.comparing(Produkt::getPreis).reversed())
                        .collect(Collectors.toList());

                view.zeigeSortierteProdukte(sortierteProdukte);
                return;
            }
        }
        System.out.println("Charakter nicht gefunden!");
    }


//    CRUD charaktere

    public void addCharakter(int id, String name, String region) {
        charaktere.add(new Charakter(id, name, region));
        System.out.println("Charakter hinzugefügt: " + name);
    }

    public void removeCharakter(int id) {
        charaktere.removeIf(c -> c.getId() == id);
        System.out.println("Charakter mit ID " + id + " wurde entfernt.");
    }

    public void updateCharakter(int id, String newName, String newRegion) {
        Optional<Charakter> optCharakter = charaktere.stream().filter(c -> c.getId() == id).findFirst();
        optCharakter.ifPresent(c -> {
            c.setName(newName);
            c.setRegion(newRegion);
            System.out.println("Charakter aktualisiert: " + newName);
        });
    }

    public Charakter getCharakterById(int id) {
        return charaktere.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

//    CRUD produkte

    public void addProdukt(String name, double preis, String universum) {
        produkte.add(new Produkt(name, preis, universum));
        System.out.println("Produkt hinzugefügt: " + name);
    }

    public void removeProdukt(String name) {
        produkte.removeIf(p -> p.getName().equalsIgnoreCase(name));
        System.out.println("Produkt entfernt: " + name);
    }

    public void updateProdukt(String oldName, String newName, double newPreis, String newUniversum) {
        Optional<Produkt> optProdukt = produkte.stream().filter(p -> p.getName().equalsIgnoreCase(oldName)).findFirst();
        optProdukt.ifPresent(p -> {
            p.setName(newName);
            p.setPreis(newPreis);
            p.setUniversum(newUniversum);
            System.out.println("Produkt aktualisiert: " + newName);
        });
    }

    public Produkt getProduktByName(String name) {
        return produkte.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
