

public class Main {
    public static void main(String[] args) {
        Command command = new Command();
        command.parseArgs(args);
        command.execute();
    }
}




