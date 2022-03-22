import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * Contains java Main command with the following arguments like mode, data, key,
 * path_to_file_to_read_data, path_to_file_to_write of the following
 * attributes respectively "-mode", "-data", "-key", "-in" and "-out".
 *
 */

public class Command {

    int key = 0;            // offset to encrypt or decrypt data

    String mode = "";       // "enc" or "dec"
    String data = "";       // data to encrypt or decrypt
    String inPath = "";     // path to file with mode, data and key
    String outPath = "";    // path to file in which encrypted data should be stored

    Algorithm algorithm = new UnicodeAlgorithm();   // type of algorithm to encrypt or decrypt data.
    // Default is Unicode algorithm

    /**
     * Executes java Main command
     */
    public void execute() {
        readData();

        switch (this.mode) {
            case "enc" -> {
                String cipherText = algorithm.encrypt(data, key);
                output(cipherText, outPath);
            }
            case "dec" -> {
                String plainText = algorithm.decrypt(data, key);
                output(plainText, outPath);
            }
            default -> {
                System.err.println("Mode is wrong. Only \"enc\" or \"dec\" are accepted.");
                System.exit(1);
            }
        }
    }

    /**
     *
     * @param message which is already encrypted / decrypted
     * @param outPath path to file where message should be stored
     *
     * The method writes encrypted or decrypted message into a file of "-out" attribute
     */
    private static void output(String message, String outPath) {
        if (outPath.equals("")) {
            System.out.println(message);
        } else {
            File file = new File(outPath);

            // try with resources because of working with output streams
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(message);
            } catch (IOException e) {
                System.err.println("Unable to write data into the file with path " + outPath);
                System.exit(1);
            }
        }
    }

    /**
     * Note: file that contains cipher text shouldn't contain mode and key values, but only one string.
     */
    private void readData() {
        if (data.equals("")) {  // prefer "-data" over "-in"
            String fileName = inPath;
            File file = new File(fileName);
            try (Scanner scn = new Scanner(file)) {
                data = scn.nextLine();      // only one string
            } catch (FileNotFoundException e) {
                System.err.println(fileName + " not found!");
                System.exit(1);
            }
        }
    }

    /**
     * Reads command line attributes and assigns values following after attributes to the class fields
     */
    public void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-alg":
                    switch (args[i + 1]) {
                        case "shift" -> algorithm = new ShiftAlgorithm();
                        case "unicode" -> algorithm = new UnicodeAlgorithm();
                        default -> {
                            System.err.println("unknown algorithm " + args[i + 1]);
                            System.exit(1);
                        }
                    }
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inPath = args[i +1];
                    break;
                case "-out":
                    outPath = args[i + 1];
                    break;
                default:
                    System.err.println("Unknown attribute");
                    System.exit(1);
                    break;
            }
        }
    }
}
