package cypher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncodeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void encode_instantiatesCorrectly_true() {
        Encode text = new Encode("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",24);
        assertTrue(text instanceof Encode);
    }

    @Test
    void plainText_getsTheEncryptionKey() {
        Encode text = new Encode("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",23);
        assertEquals(23,text.getKey());

    }

    @Test
    void encode_getsThePlainTextForEncryption_true() {
        Encode text = new Encode("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",23);
        String plainText = text.getPlainText();
        assertEquals(plainText, "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
    }

    @Test
    void encode_encodesProvidedTextGivenPlainTextAndKey_true() throws Exception {
        Encode text = new Encode("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",23);
        text.encrypt();
        assertEquals("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD",text.getEncodedText());
    }

    @Test
    void encode_ThrowExceptionForEmptyPlainText_true() throws Exception {
        Encode text = new Encode("",23);
        assertThrows(Exception.class, () -> text.encrypt());
    }
}