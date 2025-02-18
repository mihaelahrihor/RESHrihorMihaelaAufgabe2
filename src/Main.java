import controller.Controller;
import model.Charakter;
import model.Produkt;
import view.View;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Initialisierung der Produkte
        View view = new View();
        Controller controller = new Controller(view);

        controller.addProdukt(new Produkt("Mjolnir", 500.0, "Asgard"));
        controller.addProdukt(new Produkt("Vibranium-Schild", 700.0, "Wakanda"));
        controller.addProdukt(new Produkt("Infinity Gauntlet", 10000.0, "Titan"));
        controller.addProdukt(new Produkt("Web-Shooter", 250.0, "Terra"));
        controller.addProdukt(new Produkt("Arc-Reaktor", 1500.0, "Terra"));
        controller.addProdukt(new Produkt("Norn Stones", 1200.0, "Asgard"));
        controller.addProdukt(new Produkt("Quantum Suit", 3000.0, "Terra"));
        controller.addProdukt(new Produkt("X-Gene Serum", 850.0, "X-Mansion"));
        controller.addProdukt(new Produkt("Cosmic Cube", 9000.0, "Multiverse"));
        controller.addProdukt(new Produkt("Darkhold", 2000.0, "Multiverse"));
