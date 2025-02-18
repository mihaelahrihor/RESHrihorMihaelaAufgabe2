package controller;

import model.Charakter;
import model.Produkt;
import view.MarvelView;

import java.util.Comparator;
import java.util.List;
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
}
