package cypher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Hello and Welcome to riko's Ceaser Cypher! Do you want to encode text or decode? Enter 'E' to encode and 'D' to decode!");

        InputStreamReader streamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String enteredText = bufferedReader.readLine();


        if(enteredText.equalsIgnoreCase("e")){
            try {
                System.out.println("Enter text to encrypt: ");

                InputStreamReader streamReader1 = new InputStreamReader(System.in);

                BufferedReader bufferedReader1 = new BufferedReader(streamReader1);

                String plainText = bufferedReader1.readLine();

                System.out.println("Enter encryption key: ");

                Scanner streamReader2 = new Scanner(System.in);

                int encryptionKey = streamReader2.nextInt();

                Encode text = new Encode(plainText,encryptionKey);

                text.encrypt();

                String encryptedText = text.getEncodedText();

                System.out.println(plainText + " becomes " + encryptedText + " when encrypted with and encryption key of " + encryptionKey + "!");

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        } else if (enteredText.equalsIgnoreCase("d")) {
            try {
                System.out.println("Enter text to decrypt: ");

                InputStreamReader streamReader1 = new InputStreamReader(System.in);

                BufferedReader bufferedReader1 = new BufferedReader(streamReader1);

                String encryptedText = bufferedReader1.readLine();

                System.out.println("Enter decryption key: ");

                Scanner streamReader2 = new Scanner(System.in);

                int decryptionKey = streamReader2.nextInt();

                Decode text = new Decode(encryptedText,decryptionKey);

                text.decrypt();

                String decryptedText = text.getPlainText();

                System.out.println(encryptedText + " becomes " + decryptedText + " when decrypted with a decryption key of " + decryptionKey + "!");

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }else throw new IOException("You entered an invalid choice!");

    }
}
