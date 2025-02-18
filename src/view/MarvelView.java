package view;

import model.Charakter;
import model.Produkt;

import java.util.List;

public class MarvelView {
    public void zeigeCharaktere(List<Charakter> charaktere) {
        System.out.println("Liste der Charaktere:");
        for (Charakter c : charaktere) {
            System.out.println("- " + c.getName() + " aus " + c.getRegion());
        }
    }

    public void zeigeProdukteEinesCharakters(Charakter c) {
        System.out.println("Produkte von " + c.getName() + ":");
        for (Produkt p : c.getGekaufteProdukte()) {
            System.out.println("- " + p.getName() + " (" + p.getPreis() + " Credits)");
        }
    }

    public void zeigeSortierteProdukte(List<Produkt> produkte) {
        System.out.println("Sortierte Produkte:");
        for (Produkt p : produkte) {
            System.out.println("- " + p.getName() + " (" + p.getPreis() + " Credits)");
        }
    }
}
