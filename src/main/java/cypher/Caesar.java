package cypher;

import java.util.Scanner;

import static cypher.Decode.decryptText;
import static cypher.Encode.encryptText;

public class Caesar {


    public static void main(String[] args) {

        System.out.println("Enter text to encrypt: ");
//        the scanner collects user input for the string that needs to be encoded
        Scanner userInput = new Scanner(System.in);

        String enteredText = userInput.nextLine();

//        call the encryptText method and pass in a key and the text collected from the user
        String text1 = encryptText(enteredText,1);

//        call the decrypt method to change the text back to what it was before the encryption
        String text2 = decryptText(text1,1);
        System.out.println(text1 + " becomes " + text2 + " when decrypted");


    }
}
