package cypher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void decode_instantiatesCorrectly_true() {
        Decode text = new Decode("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD",23);
        assertTrue(text instanceof Decode);
    }

    @Test
    void encodedText_getsTheDecryptionKey() {
        Decode text = new Decode("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD",23);
        assertEquals(23,text.getKey());

    }

    @Test
    void decode_getsTheEncodedTextForDecryption_true() {
        Decode text = new Decode("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD",23);
        String encodedText = text.getEncodedText();
        assertEquals(encodedText, "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD");
    }

    @Test
    void decode_decodesProvidedTextGivenEncryptedTextAndKey_true() throws Exception {
        Decode text = new Decode("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD",23);
        text.decrypt();
        assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG",text.getPlainText());
    }

    @Test
    void encode_ThrowExceptionForEmptyPlainText_true() throws Exception {
        Decode text = new Decode("",23);
        assertThrows(Exception.class, () -> text.decrypt());
    }
}