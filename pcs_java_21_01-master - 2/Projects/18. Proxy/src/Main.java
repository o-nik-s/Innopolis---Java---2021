public class Main {

    public static void main(String[] args) {
        InputOutput inputOutput = new FileIO("file.txt");

        inputOutput = LoggerWrapper.withLogger(inputOutput);

        inputOutput.output("Hello!");
        inputOutput.output("How are you?");
        inputOutput.output("I'm fine!");

        System.out.println(inputOutput.input());
    }
}
