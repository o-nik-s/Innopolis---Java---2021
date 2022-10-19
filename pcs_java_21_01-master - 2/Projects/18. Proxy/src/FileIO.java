import java.io.*;
import java.util.stream.Collectors;

/**
 * 22.09.2021
 * 18. Proxy
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileIO implements InputOutput {

    private String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void output(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text + " ");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String input() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
