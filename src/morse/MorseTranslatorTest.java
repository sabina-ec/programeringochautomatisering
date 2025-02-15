package morse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseTranslatorTest {

    // Testar konvertering av strängen "SABINA" till Morse-kod.
    @Test
    public void testToMorseSuccess() {
        assertEquals("... .- -... .. -. .-", MorseLogic.toMorse("SABINA"));
    }

    // Testar konvertering av Morse-koden ".... . .---" till text.
    @Test
    public void testFromMorseSuccess() {
        assertEquals("HEJ", MorseLogic.fromMorse(".... . .---"));
    }

    // Testar konvertering av strängen "hello" till Morse-kod.
    @Test
    public void testToMorseLowerCaseSuccess() {
        assertEquals(".... . .-.. .-.. ---", MorseLogic.toMorse("hello"));
    }

    // Testar fallet när inmatningen är en tom sträng "".
    @Test
    void testToMorseEmptyInput() {
        assertEquals("Fel: Ingen text angiven. Försök igen.", MorseLogic.toMorse(""));
    }

    // Testar fallet när inmatningen innehåller en okänd symbol "@"
    @Test
    void testToMorseUnknownCharacter() {
        assertEquals("Fel: Okänd symbol - @", MorseLogic.toMorse("Hej@"));
    }

    // Testar fallet när en okänd Morse-kod "..---" anges.
    @Test
    void testFromMorseUnknownCode() {
        assertEquals("Fel: Okänd Morse-kod - ..---", MorseLogic.fromMorse("..---"));
    }
}


