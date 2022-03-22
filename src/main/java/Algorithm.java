
/**
 * Basis class for two types of algorithms
 */
public abstract class Algorithm {

    abstract String encrypt(String message, int key);

    abstract String decrypt(String message, int key);
}
