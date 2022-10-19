import java.io.*;
import java.util.Scanner;

/**
 * 12.09.2021
 * 13. DAO, Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class IdGeneratorFileImpl implements IdGenerator {

    private final String fileName;

    public IdGeneratorFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            int lastId = scanner.nextInt();
            lastId++;
            scanner.close();
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
                printWriter.print(lastId);
            }
            return lastId;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
