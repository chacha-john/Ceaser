package cypher;

public class Encode {
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

}
