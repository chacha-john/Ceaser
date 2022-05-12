package cypher;

public class Encode {
private String plainText;
private int key;
private String encodedText;

    public Encode(String plainText, int key) {
        this.plainText = plainText;
        this.key = key;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getEncodedText() {
        return encodedText;
    }

    public void setEncodedText(String encodedText) {
        this.encodedText = encodedText;
    }

    public void encrypt() throws Exception {
        if(this.plainText.isEmpty() || this.plainText.isBlank()){
            throw new Exception("The string supplied is invalid!");
        }
        if(key>26){
            key=key%26; //The key has to be between 1 and 26. If it is more, we take assign the key to the modulus
        } else if (key<1) {
            key=(key%26)+26; // converts negative keys to positive

        }

        String encryptedText = "";


            //loop through each character in the entire string entered by user
            for(int i = 0;i<plainText.length();i++){
                char specificCharacter = plainText.charAt(i);

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
        this.setEncodedText(encryptedText);
    }
}
