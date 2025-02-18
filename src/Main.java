import controller.MarvelController;
import model.Charakter;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        aufgabe2();

    }
public static void aufgabe2() {
// Initialisierung der Produkte
    List<Produkt> produkte = new ArrayList<>();
    produkte.add(new Produkt("Mjolnir", 500.0, "Asgard"));
    produkte.add(new Produkt("Vibranium-Schild", 700.0, "Wakanda"));
    produkte.add(new Produkt("Infinity Gauntlet", 10000.0, "Titan"));
    produkte.add(new Produkt("Web-Shooter", 250.0, "Terra"));
    produkte.add(new Produkt("Arc-Reaktor", 1500.0, "Terra"));
    produkte.add(new Produkt("Norn Stones", 1200.0, "Asgard"));
    produkte.add(new Produkt("Quantum Suit", 3000.0, "Terra"));
    produkte.add(new Produkt("X-Gene Serum", 850.0, "X-Mansion"));
    produkte.add(new Produkt("Cosmic Cube", 9000.0, "Multiverse"));
    produkte.add(new Produkt("Darkhold", 2000.0, "Multiverse"));
// Initialisierung der Charaktere
    List<Charakter> charaktere = new ArrayList<>();
    Charakter c1 = new Charakter(1, "Thor", "Asgard");
    c1.kaufeProdukt(produkte.get(0)); // Mjolnir
    c1.kaufeProdukt(produkte.get(5)); // Norn Stones
    c1.kaufeProdukt(produkte.get(9)); // Darkhold
    Charakter c2 = new Charakter(2, "Black Panther", "Wakanda");
    c2.kaufeProdukt(produkte.get(1)); // Vibranium-Schild
    c2.kaufeProdukt(produkte.get(7)); // X-Gene Serum
    Charakter c3 = new Charakter(3, "Iron Man", "Terra");
    c3.kaufeProdukt(produkte.get(4)); // Arc-Reaktor
    c3.kaufeProdukt(produkte.get(6)); // Quantum Suit
    c3.kaufeProdukt(produkte.get(3)); // Web-Shooter
    Charakter c4 = new Charakter(4, "Spider-Man", "Terra");
    c4.kaufeProdukt(produkte.get(3)); // Web-Shooter
    c4.kaufeProdukt(produkte.get(8)); // Cosmic Cube
    Charakter c5 = new Charakter(5, "Doctor Strange", "Multiverse");
    c5.kaufeProdukt(produkte.get(9)); // Darkhold
    c5.kaufeProdukt(produkte.get(8)); // Cosmic Cube
    c5.kaufeProdukt(produkte.get(2)); // Infinity Gauntlet
    charaktere.add(c1);
    charaktere.add(c2);
    charaktere.add(c3);
    charaktere.add(c4);
    charaktere.add(c5);



    MarvelController controller = new MarvelController(produkte, charaktere);
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\nMarvel Handelsnetzwerk");
        System.out.println("1 - Alle Charaktere anzeigen");
        System.out.println("2 - Produkte eines Charakters anzeigen");
        System.out.println("3 - Produkte eines Charakters sortieren");
        System.out.println("4 - CRUD - Produkte eines Charakters sortieren");
        System.out.println("5 -  CRUD - Charaktere eines Charakters sortieren");

        System.out.println("0 - Beenden");
        System.out.print("Auswahl: ");

        int auswahl = scanner.nextInt();
        scanner.nextLine();

        switch (auswahl) {
            case 1:
                controller.zeigeAlleCharaktere();
                break;
            case 2:
                System.out.print("Charaktername eingeben: ");
                String name = scanner.nextLine();
                controller.zeigeProdukteEinesCharakters(name);
                break;
            case 3:
                System.out.print("Charaktername eingeben: ");
                String charName = scanner.nextLine();
                System.out.print("Sortierung (1 = aufsteigend, 2 = absteigend): ");
                int sortierung = scanner.nextInt();
                boolean aufsteigend = (sortierung == 1);
                controller.sortiereProdukteEinesCharakters(charName, aufsteigend);
                break;
            case 4:
                verwalteProdukte(controller, scanner);
                break;
            case 5:
                verwalteCharaktere(controller, scanner);
                break;
            case 0:
                System.out.println("Programm beendet.");
                return;
            default:
                System.out.println("Ungültige Eingabe!");
        }
    }


}


private static void verwalteProdukte(MarvelController controller, Scanner scanner) {
    while (true) {

        controller.zeigeAlleProdukte();

        System.out.println("\nProdukte verwalten:");
        System.out.println("1 - Neues Produkt hinzufügen");
        System.out.println("2 - Produkt aktualisieren");
        System.out.println("3 - Produkt entfernen");
        System.out.println("4 - Produkt suchen");
        System.out.println("0 - Zurück");
        System.out.print("Auswahl: ");

        int wahl = scanner.nextInt();
        scanner.nextLine();

        switch (wahl) {
            case 1:
                System.out.print("Produktname: ");
                String produktName = scanner.nextLine();
                System.out.print("Preis: ");
                double preis = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Universum: ");
                String universum = scanner.nextLine();
                controller.addProdukt(produktName, preis, universum);
                break;

            case 2:
                System.out.print("Aktueller Produktname: ");
                String alterName = scanner.nextLine();
                System.out.print("Neuer Produktname: ");
                String neuerName = scanner.nextLine();
                System.out.print("Neuer Preis: ");
                double neuerPreis = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Neues Universum: ");
                String neuesUniversum = scanner.nextLine();
                controller.updateProdukt(alterName, neuerName, neuerPreis, neuesUniversum);
                break;

            case 3:
                System.out.print("Produktname zum Entfernen: ");
                String nameEntfernen = scanner.nextLine();
                controller.removeProdukt(nameEntfernen);
                break;

            case 4:
                System.out.print("Produktname zum Suchen: ");
                String nameSuchen = scanner.nextLine();
                Produkt gefundenesProdukt = controller.getProduktByName(nameSuchen);
                if (gefundenesProdukt != null) {
                    System.out.println("Gefunden: " + gefundenesProdukt.getName() + " (" + gefundenesProdukt.getPreis() + " Credits, Universum: " + gefundenesProdukt.getUniversum() + ")");
                } else {
                    System.out.println("Produkt nicht gefunden!");
                }
                break;

            case 0:
                return;

            default:
                System.out.println("Ungültige Eingabe!");
        }
    }
}

private static void verwalteCharaktere(MarvelController controller, Scanner scanner) {
    while (true) {


        controller.zeigeAlleCharaktere();

        System.out.println("\nCharaktere verwalten:");
        System.out.println("1 - Neuen Charakter hinzufügen");
        System.out.println("2 - Charakter aktualisieren");
        System.out.println("3 - Charakter entfernen");
        System.out.println("4 - Charakter suchen");
        System.out.println("0 - Zurück");
        System.out.print("Auswahl: ");

        int wahl = scanner.nextInt();
        scanner.nextLine();

        switch (wahl) {
            case 1:
                System.out.print("Charakter ID: ");
                int charId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Charaktername: ");
                String charName = scanner.nextLine();
                System.out.print("Region: ");
                String charRegion = scanner.nextLine();
                controller.addCharakter(charId, charName, charRegion);
                break;

            case 2:
                System.out.print("Charakter ID zum Aktualisieren: ");
                int idAktualisieren = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Neuer Name: ");
                String neuerCharName = scanner.nextLine();
                System.out.print("Neue Region: ");
                String neueRegion = scanner.nextLine();
                controller.updateCharakter(idAktualisieren, neuerCharName, neueRegion);
                break;

            case 3:
                System.out.print("Charakter ID zum Entfernen: ");
                int idEntfernen = scanner.nextInt();
                scanner.nextLine();
                controller.removeCharakter(idEntfernen);
                break;

            case 4:
                System.out.print("Charakter ID zum Suchen: ");
                int idSuchen = scanner.nextInt();
                scanner.nextLine();
                Charakter gefundenerChar = controller.getCharakterById(idSuchen);
                if (gefundenerChar != null) {
                    System.out.println("Gefunden: " + gefundenerChar.getName() + " aus " + gefundenerChar.getRegion());
                } else {
                    System.out.println("Charakter nicht gefunden!");
                }
                break;

            case 0:
                return;

            default:
                System.out.println("Ungültige Eingabe!");
        }
    }
}

}