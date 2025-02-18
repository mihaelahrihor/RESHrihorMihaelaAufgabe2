package view;

import model.Charakter;
import model.Produkt;

import java.util.List;

public class View {
    public void displayCharacters(List<Charakter> characters) {
        for (Charakter c : characters) {
            System.out.println(c.getName());
        }
    }

    public void displayProducts(List<Produkt> products) {
        for (Produkt p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }
    }
}
