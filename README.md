# Enigma

Enigma is the tool for enctypting and decrypting messages using two types of algorithms:

1. Unicode algorithm
2. Shift algorithm

Main class and its main method works only with the CLI. In case of running it via IDE, you should specify CLI arguments for the application.
Speaking about Intellij IDEA, go to RUN -> Edit Configurations. Fill arguments in the field called "Program arguments".

Attributes of Java Main command:

1. -mode: specifies the option to decrypt or encrypt a message. The attribute has only two values which are "enc" and "dec" for encryption and decryption respectively.
2. -in: specifies the path to file where a plaintext is stored. For example, -in path_to_file_without_quotation_marks.
3. -out: specifies the path to file where a cipher text should be stored. For example, -out path_to_file_without_quotation_marks.
4. -key: specifies the numeric key for encryption/decryption.
5. -data: specifies the message in quotation marks in case of -in or -out attribute absence. For example, -data "Message_to_encrypt" / -data "Message_to_decrypt".
6. -alg: specifies the type of algorithm. The attribute has only two values which are "unicode" and "shift" for unicode algorithm and shift algorithm respectively.

The specifics of the program:

1. If there is no -mode, the program works in enc mode.
2. If there is no -key, the program considers that key = 0.
3. If there is no -data, and there is no -in the program assumes that the data is an empty string.
4. If there is no -out argument, the program prints data to the CLI.
5. If there are both -data and -in arguments, your program prefers -data over -in.

How to use:
1. Open directory with the compiled Main class
2. Write command -> Java Main {attribute} {value}

![CLI](https://user-images.githubusercontent.com/64216083/159449234-dff726f1-bb2d-4264-be3d-774572feaca3.png)
![plaintext](https://user-images.githubusercontent.com/64216083/159449242-2d296651-c40f-4b8a-bc6a-5d893187622c.png)
![cyphertext](https://user-images.githubusercontent.com/64216083/159449258-a72e144a-1e3f-4949-b670-791a96c35d35.png)
