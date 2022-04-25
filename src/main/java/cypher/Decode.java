package cypher;

public class Decode {
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
}
