package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CsvFileProcessor {
    private final String fileName;

    public CsvFileProcessor(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Возвращает количество строк с определенными данным
     *
     * @param position позиция в столбце
     * @param value    значение, которое должно быть в столбце
     * @return количество строк со значением <code>value</code> в позиции <code>position</code>
     */
    public long countByPosition(int position, String value) {
        long count = 0;
        // открываем файл для чтения
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // читаем строку
            String line = reader.readLine();
            // если строка не пустая
            while (line != null) {
                // разбиваем его по запятым
                String[] parts = line.split(",");
                // проверяем, соответствует ли строка условию
                if (parts[position].equals(value)) {
                    count++;
                }
                // читаем следующую строку
                line = reader.readLine();
            }

            return count;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void readValuesByPositionWithExchanger(int position, Exchanger<List<String>> exchanger, int bufferSize) {
        List<String> buffer = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                buffer.add(line.split(",")[position]);

                if (buffer.size() == bufferSize) {
                    System.out.println("CsvFileProcessor - передача в обработку");
                    exchanger.exchange(buffer);
                    System.out.println("CsvFileProcessor - передано в обработку");
                    buffer = new ArrayList<>();
                }

                line = reader.readLine();
            }
            exchanger.exchange(null);
        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
