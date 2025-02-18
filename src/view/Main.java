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

        // Initialisierung der Charaktere
        List<Charakter> charaktere = new ArrayList<>();

        Charakter c1 = new Charakter(1, "Thor", "Asgard");
        c1.kaufeProdukt(controller.getProducts().get(0)); // Mjolnir
        c1.kaufeProdukt(controller.getProducts().get(5)); // Norn Stones
        c1.kaufeProdukt(controller.getProducts().get(9)); // Darkhold

        Charakter c2 = new Charakter(2, "Black Panther", "Wakanda");
        c2.kaufeProdukt(controller.getProducts().get(1)); // Vibranium-Schild
        c2.kaufeProdukt(controller.getProducts().get(7)); // X-Gene Serum

        Charakter c3 = new Charakter(3, "Iron Man", "Terra");
        c3.kaufeProdukt(controller.getProducts().get(4)); // Arc-Reaktor
        c3.kaufeProdukt(controller.getProducts().get(6)); // Quantum Suit
        c3.kaufeProdukt(controller.getProducts().get(3)); // Web-Shooter

        Charakter c4 = new Charakter(4, "Spider-Man", "Terra");
        c4.kaufeProdukt(controller.getProducts().get(3)); // Web-Shooter
        c4.kaufeProdukt(controller.getProducts().get(8)); // Cosmic Cube

        Charakter c5 = new Charakter(5, "Doctor Strange", "Multiverse");
        c5.kaufeProdukt(controller.getProducts().get(9)); // Darkhold
        c5.kaufeProdukt(controller.getProducts().get(8)); // Cosmic Cube
        c5.kaufeProdukt(controller.getProducts().get(2)); // Infinity Gauntlet


        controller.addCharakter(c1);
        controller.addCharakter(c2);
        controller.addCharakter(c3);
        controller.addCharakter(c4);
        controller.addCharakter(c5);


        controller.buyProdukt(1, "Mjolnir");
//        controller.filterCharactersByRegion();




    }
}