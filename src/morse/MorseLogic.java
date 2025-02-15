package morse;

import java.util.HashMap;

public class MorseLogic {
                              // HashMap som kopplar bokstäver (char) till Morse-kod (String)
                              // Används för att omvandla text till Morse-kod
    private static final HashMap<Character, String> morseMap = new HashMap<>();

                               // HashMap som kopplar Morse-kod (String) till bokstäver (char)
                              // Används för att dekryptera Morse-kod tillbaka till text

    private static final HashMap<String, Character> reverseMorseMap = new HashMap<>();

    // Statisk block som fyller morseMap med bokstäver och deras Morse-koder
    static {
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");

                               // Den här loopen går igenom alla nycklar i morseMap,
                              //hämtar motsvarande värden och skapar en ny karta reverseMorseMap,
                             //där nycklar och värden byts plats.

        for (Character key : morseMap.keySet()) {
            String value = morseMap.get(key);   // Hämta Morse-koden för bokstaven
            reverseMorseMap.put(value, key);    // Lägg in i den omvända mappen
        }


    }

    // Denna metod konverterar engelsk text till Morse-kod.
    public static String toMorse(String text) {
        if (text.isEmpty()) {                                //Kontrollerar om inmatningen är tom
            return "Fel: Ingen text angiven. Försök igen.";  // Om texten är tom, returnerar vi felmeddelandet
        }

        StringBuilder morseCode = new StringBuilder();         //objekt som vi använder för att bygga Morse-koden.
        for (int i = 0; i < text.length(); i++) {              //Startar en for-loop som går igenom varje tecken i text.
            char c = Character.toUpperCase(text.charAt(i));    //Hämtar tecknet på position i i texten och omvandlar det till versaler (A-Z).
            if (morseMap.containsKey(c)) {                     //Kontrollerar om tecknet c finns i morseMap
                morseCode.append(morseMap.get(c)).append(" "); //Om tecknet c finns i morseMap, hämtar vi dess Morse-kod och lägger till den i morseCode..append(" ") lägger till ett mellanslag mellan varje Morse-tecken.
            } else {                                           //Om tecknet inte finns i morseMap, returnerar vi felmeddelandet
                return "Fel: Okänd symbol - " + c;
            }
        }

        return morseCode.toString().trim();      //Omvandlar StringBuilder till en vanlig String och
                                                 // tar bort sista mellanslaget (trim()).
    }


    //Denna metod konverterar Morse-kod till engelsk text.
    public static String fromMorse(String morse) {
        if (morse.isEmpty()) {
            return "Fel: Ingen Morse-kod angiven. Försök igen.";
        }

        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" ");       //Delar upp Morse-koden i separata tecken genom att använda " " (mellanslag) som avgränsare.
        for (String word : words) {                     //Startar en for-loop för att gå igenom varje Morse-tecken i words.
            if (reverseMorseMap.containsKey(word)) {    //Kontrollerar om Morse-koden finns i reverseMorseMap,vilket betyder att den har en matchande bokstav.
                text.append(reverseMorseMap.get(word));  // Om Morse-koden finns i reverseMorseMap, hämtar vi dess bokstav och lägger till den i text.
            } else {
                return "Fel: Okänd Morse-kod - " + word;   //Om Morse-koden inte finns i reverseMorseMap, returnerar vi felmeddelandet
            }
        }
        return text.toString();        // Omvandlar StringBuilder till en vanlig String och returnerar den översatta texten.
    }

}
