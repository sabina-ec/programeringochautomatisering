package morse;

import java.util.HashMap;

public class MorseLogic {
    // HashMap som lagrar bokstäver (A-Z) och deras motsvarande Morse-koder
    private static final HashMap<Character, String> morseMap = new HashMap<>();

    // HashMap som lagrar Morse-koder som nycklar och motsvarande bokstäver som värden
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

        // Genererar den omvända hashmappen för att möjliggöra konvertering från Morse-kod till text
        generateReverseHashMap();
    }

    /**
     * Metod som konverterar en engelsk text till Morse-kod.
     * @param text Den text som ska översättas
     * @return Morse-kod som en sträng, eller felmeddelande om ogiltiga tecken används
     */
    public static String toMorse(String text) {
        if (text.isEmpty()) {                                // Kontrollerar om inmatningen är tom
            return "Fel: Ingen text angiven. Försök igen.";  // Returnerar felmeddelande om inmatningen är tom
        }

        StringBuilder morseBuilder = new StringBuilder();    // Skapar en StringBuilder för att bygga Morse-koden

        for (int i = 0; i < text.length(); i++) {            // Loopar igenom varje tecken i texten
            char upperKey = Character.toUpperCase(text.charAt(i)); // Omvandlar tecknet till versaler (A-Z)
            if (morseMap.containsKey(upperKey)) {             // Kontrollerar om tecknet finns i morseMap
                var value = morseMap.get(upperKey);          // Hämtar motsvarande Morse-kod
                morseBuilder.append(value).append(" ");      // Lägger till Morse-koden och ett mellanslag
            } else {                                         // Om tecknet inte finns i morseMap
                return "Fel: Okänd symbol - " + upperKey;    // Returnerar felmeddelande
            }
        }

        return morseBuilder.toString().trim();   // Omvandlar StringBuilder till en sträng och tar bort sista mellanslaget
    }

    /**
     * Metod som konverterar Morse-kod till engelsk text.
     * @param morse Morse-koden som ska översättas
     * @return Den översatta texten, eller felmeddelande vid ogiltig inmatning
     */
    public static String fromMorse(String morse) {
        if (morse.isEmpty()) {                              // Kontrollerar om inmatningen är tom
            return "Fel: Ingen Morse-kod angiven. Försök igen.";  // Returnerar felmeddelande om inmatningen är tom
        }

        StringBuilder textBuilder = new StringBuilder();    // Skapar en StringBuilder för att bygga texten
        String[] morseCodes = morse.split(" ");             // Delar upp Morse-koden i separata tecken med mellanslag som avgränsare

        for (String code : morseCodes) {                    // Loopar igenom varje Morse-tecken
            if (reverseMorseMap.containsKey(code)) {        // Kontrollerar om Morse-koden finns i reverseMorseMap
                var value = reverseMorseMap.get(code);      // Hämtar motsvarande bokstav
                textBuilder.append(value);                  // Lägger till bokstaven i texten
            } else {                                        // Om Morse-koden inte finns i reverseMorseMap
                return "Fel: Okänd Morse-kod - " + code;    // Returnerar felmeddelande
            }
        }

        return textBuilder.toString();  // Omvandlar StringBuilder till en sträng och returnerar den översatta texten
    }

    /**
     * Metod som genererar en omvänd hashkarta (reverseMorseMap),
     * där nycklar och värden från morseMap byter plats.
     * Detta möjliggör översättning från Morse-kod till engelsk text.
     */
    private static void generateReverseHashMap() {
        for (Character key : morseMap.keySet()) {   // Loopar igenom alla nycklar i morseMap
            String value = morseMap.get(key);       // Hämtar Morse-koden för bokstaven
            reverseMorseMap.put(value, key);        // Lägger till i den omvända hashmappen
        }
    }
}
