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
        Encode text = new Encode("trust and obey",4);
        assertTrue(text instanceof Encode);
    }

    @Test
    void plainText_getsTheEncryptionKey() {
        Encode text = new Encode("trust and obey",4);
        assertEquals(4,text.getKey());

    }

    @Test
    void encode_getsThePlainTextForEncryption_true() {
        Encode text = new Encode("trust and obey",4);
        String plainText = text.getPlainText();
        assertEquals(plainText, "trust and obey");
    }

    @Test
    void encode_encodesProvidedTextGivenPlainTextAndKey_true() throws Exception {
        Encode text = new Encode("bro",1);
        text.encrypt();
        assertEquals("csp",text.getEncodedText());
    }
}