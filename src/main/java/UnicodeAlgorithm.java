
public class UnicodeAlgorithm extends Algorithm {


    public String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            encryptedMessage.append((char) (c + key));
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }
}
