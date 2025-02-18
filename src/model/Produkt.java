package model;

public class Produkt {
    private String name;
    private double preis;
    private String universum;

    public Produkt(String name, double preis, String universum) {
        this.name = name;
        this.preis = preis;
        this.universum = universum;
    }

    public double getPreis() {
        return preis;
    }

    public String getName() {
        return name;
    }

    public String getUniversum() {
        return universum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setUniversum(String universum) {
        this.universum = universum;
    }
}
