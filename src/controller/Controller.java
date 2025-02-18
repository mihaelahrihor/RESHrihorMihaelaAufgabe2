package controller;

import model.Charakter;
import model.Produkt;
import view.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private List<Charakter> characters = new ArrayList<>();
    private List<Produkt> products = new ArrayList<>();
    private View view;

    public Controller(View view) {
        this.view = view;
    }


    public void addProdukt(Produkt produkt) {
        products.add(produkt);
    }

    public void addCharakter(Charakter charakter) {
        characters.add(charakter);
    }

    public void buyProdukt(int characterId, String productName) {
        Charakter character = characters.stream().filter(c -> c.getName().equalsIgnoreCase(productName)).findFirst().orElse(null);
        Produkt product = products.stream().filter(p -> p.getName().equalsIgnoreCase(productName)).findFirst().orElse(null);
        if (character != null && product != null) {
            character.kaufeProdukt(product);
        }
    }

    public void filterCharactersByRegion(String region) {
        List<Charakter> filtered = characters.stream()
                .filter(c -> c.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
        view.displayCharacters(filtered);
    }

    public void showCharactersByPurchasedUniverse(String universe) {
        List<Charakter> filtered = characters.stream()
                .filter(c -> c.getPurchasedProducts().stream().anyMatch(p -> p.getUniverse().equalsIgnoreCase(universe)))
                .sorted(Comparator.comparing(Charakter::getName))
                .collect(Collectors.toList());
        view.displayCharacters(filtered);
    }
