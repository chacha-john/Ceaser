package cypher;

public class Decode {
    private String plainText;
    private int key;
    private String encodedText;

    public Decode(String encodedText, int key) {
        this.encodedText = encodedText;
        this.key = key;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getEncodedText() {
        return encodedText;
    }

    public void setEncodedText(String encodedText) {
        this.encodedText = encodedText;
    }

    public void decrypt() throws Exception {
        if(this.encodedText.isEmpty() || this.encodedText.isBlank()){
            throw new Exception("The string supplied is invalid!");
        }
        if(key>26){
            key=key%26; //The key has to be between 1 and 26. If it is more, we take assign the key to the modulus
        } else if (key<1) {
            key=(key%26)+26; // converts negative keys to positive

        }

        String decryptedText = "";


        //loop through each character in the entire string entered by user
        for(int i = 0;i<encodedText.length();i++){
            char specificCharacter = encodedText.charAt(i);

            //check to see if the character is a letter and shift it according to provided key
            if(Character.isLetter(specificCharacter)){
                if (Character.isLowerCase(specificCharacter)){

                    //Casting to change the data type from int to character
                    char ch = (char) (specificCharacter-key);

                    //if the resulting character is less than an 'a', go allover the alphabet again
                    if (ch<'a'){
                        decryptedText += (char) (specificCharacter + (26-key));
                    }
                    //if the resulting character is within the alphabet, add it as is
                    else{
                        decryptedText += ch;
                    }
                } else if (Character.isUpperCase(specificCharacter)) {
                    char ch = (char) (specificCharacter-key);

                    //if the resulting character is less than an 'A', go allover the alphabet again
                    if (ch<'A'){
                        decryptedText += (char) (specificCharacter + (26-key));
                    }
                    //if the resulting character is within the alphabet, add it as is
                    else{
                        decryptedText += ch;
                    }
                }
            }
            //characters that are not letters remain just as they are
            else{
                decryptedText +=specificCharacter;
            }
        }

        //the method returns the encrypted text
        this.setPlainText(decryptedText);
    }
}
