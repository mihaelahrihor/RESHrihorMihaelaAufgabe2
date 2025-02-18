package model;

import java.util.ArrayList;
import java.util.List;

public class Charakter {
    private int id;
    private String name;
    private String region;
    private List<Produkt> gekaufteProdukte;

    public Charakter(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.gekaufteProdukte = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGekaufteProdukte(List<Produkt> gekaufteProdukte) {
        this.gekaufteProdukte = gekaufteProdukte;
    }

    public void kaufeProdukt(Produkt produkt) {
        gekaufteProdukte.add(produkt);
    }

    public List<Produkt> getGekaufteProdukte() {
        return gekaufteProdukte;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }
}
