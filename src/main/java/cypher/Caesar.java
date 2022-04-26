package cypher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static cypher.Decode.decryptText;
import static cypher.Encode.encryptText;

public class Caesar {


    public static void main(String[] args) {

        try {
            System.out.println("Enter text to encrypt: ");
//        InputStreamReader collects user input
            InputStreamReader streamReader = new InputStreamReader(System.in);

//        BufferedReader reads the collected input
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String enteredText = bufferedReader.readLine();

//        call the encryptText method and pass in a key and the text collected from the user
            String text1 = encryptText(enteredText, 1);

//        call the decrypt method to change the text back to what it was before the encryption
            String text2 = decryptText(text1, 1);
            System.out.println(text1 + " becomes " + text2 + " when decrypted");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
