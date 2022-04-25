package cypher;

import java.util.Scanner;

public class Caesar {
    public static String encryptText(String enteredText, int key){
        //the key can only be a positive integer between 1 and 26
        if (key>26){
            key=key%26;
        }
        else if(key<1){
            key = (key%26)+26;
        }


        //empty string that will hold encrypted text
        String encryptedText = "";

        //loop through each character in the entire string entered by user
        for(int i = 0;i<enteredText.length();i++){
            char specificCharacter = enteredText.charAt(i);

            //check to see if the character is a letter and shift it according to provided key
            if(Character.isLetter(specificCharacter)){
                if (Character.isLowerCase(specificCharacter)){

                    //Casting to change the data type from int to character
                    char ch = (char) (specificCharacter+key);

                    //if the resulting character is greater than a 'z', go allover the alphabet again
                    if (ch>'z'){
                        encryptedText += (char) (specificCharacter - (26-key));
                    }
                    //if the resulting character is within the alphabet, add it as is
                    else{
                        encryptedText += ch;
                    }
                } else if (Character.isUpperCase(specificCharacter)) {
                    char ch = (char) (specificCharacter+key);

                    //if the resulting character is greater than a 'Z', go allover the alphabet again
                    if (ch>'Z'){
                        encryptedText += (char) (specificCharacter - (26-key));
                    }
                    //if the resulting character is within the alphabet, add it as is
                    else{
                        encryptedText += ch;
                    }
                }
            }
            //characters that are not letters remain just as they are
            else{
                encryptedText +=specificCharacter;
            }
        }

        //the method returns the encrypted text
        return encryptedText;

    }

    public static String decryptText(String enteredText, int key){
        //the key can only be a positive integer between 1 and 26
        if (key>26){
            key=key%26;
        }
        else if(key<1){
            key = (key%26)+26;
        }


        //empty string that will hold encrypted text
        String encryptedText = "";

        //loop through each character in the entire string entered by user
        for(int i = 0;i<enteredText.length();i++){
            char specificCharacter = enteredText.charAt(i);

            //check to see if the character is a letter and shift it according to provided key
            if(Character.isLetter(specificCharacter)){
                if (Character.isLowerCase(specificCharacter)){

                    //Casting to change the data type from int to character
                    char ch = (char) (specificCharacter-key);

                    //if the resulting character is less than an 'a', go allover the alphabet again
                    if (ch<'a'){
                        encryptedText += (char) (specificCharacter + (26-key));
                    }
                    //if the resulting character is within the alphabet, add it as is
                    else{
                        encryptedText += ch;
                    }
                } else if (Character.isUpperCase(specificCharacter)) {
                    char ch = (char) (specificCharacter-key);

                    //if the resulting character is less than an 'A', go allover the alphabet again
                    if (ch<'A'){
                        encryptedText += (char) (specificCharacter + (26-key));
                    }
                    //if the resulting character is within the alphabet, add it as is
                    else{
                        encryptedText += ch;
                    }
                }
            }
            //characters that are not letters remain just as they are
            else{
                encryptedText +=specificCharacter;
            }
        }

        //the method returns the decrypted text
        return encryptedText;

    }
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
