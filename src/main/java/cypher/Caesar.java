package cypher;

public class Caesar {
    public static String EncryptText(String enteredText, int key){
        //the key can only be a positive integer between 1 and 25
        if (key>25){
            key=key%25;
        }
        else if(key<1){
            key = (key%25)+25;
        }


        //empty string that will hold encrypted text
        String encryptedText = "";

        //loop through each character in the entire string entered by user
        for(int i = 0;i<enteredText.length();i++){
            char specificCharacter = enteredText.charAt(i);

            //check to see if the character is a letter and shift it according to provided key
            if(Character.isLetter(specificCharacter)){
                if (Character.isLowerCase(specificCharacter)){


                    char ch = (char) (specificCharacter+key); //Casting to change the data type from int to character
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
    public static void main(String[] args) {

    }
}
