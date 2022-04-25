package cypher;

public class Caesar {
    public static String EncryptText(String enteredText, int key){
        String encryptedText = "";
        for(int i = 0;i<enteredText.length();i++){
            char specificCharacter = enteredText.charAt(i);
            if(Character.isLetter(specificCharacter)){

            }
            else{
                encryptedText +=specificCharacter;
            }
        }

    }
    public static void main(String[] args) {

    }
}
