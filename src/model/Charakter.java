package model;

import java.util.ArrayList;
import java.util.List;

public class Charakter {
    private int id;
    private String name;
    private String region;
    private List<Produkt> purchasedProducts = new ArrayList<>();

    public Charakter(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public void kaufeProdukt(Produkt product) {
        purchasedProducts.add(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Produkt> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<Produkt> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}