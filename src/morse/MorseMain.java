package morse;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {

        // Skapar en Scanner för att läsa inmatning från användaren
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Välkommen till programmet.");
            System.out.println("Du kan välja ett av följande alternativ:");
            System.out.println("1 - Konvertera engelsk text till Morse-kod");
            System.out.println("2 - Konvertera Morse-kod till engelsk text");

            // Läser in användarens val (1 eller 2)
            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensar bufferten efter nummerinmatning

            // Om användaren valde 1: Konvertera text till Morse-kod
            if (choice == 1) {
                System.out.print("Ange text: ");
                String text = scanner.nextLine().trim(); // Läser in texten och tar bort onödiga mellanslag
                System.out.println(MorseLogic.toMorse(text)); // Skriver ut den konverterade Morse-koden

                // Om användaren valde 2: Konvertera Morse-kod till engelsk text
            } else if (choice == 2) {
                System.out.print("Ange Morse-kod (separera med mellanslag): ");
                String morse = scanner.nextLine().trim(); // Läser in Morse-koden
                System.out.println(MorseLogic.fromMorse(morse)); // Skriver ut den konverterade texten

                // Om användaren anger ett ogiltigt val
            } else {
                System.out.println("Fel: Ogiltigt val. Välj 1 eller 2.");
            }

            // Fångar fel om användaren anger något annat än en siffra (1 eller 2)
        } catch (InputMismatchException e) {
            System.out.println("Fel: Ogiltigt val. Ange ett nummer (1 eller 2).");
        }
    }
}

