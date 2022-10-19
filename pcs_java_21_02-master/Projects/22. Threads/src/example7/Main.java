package example7;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 21.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void saveFile(String link) {
        try {
            // объект для обращения к ссылке
            URL url = new URL(link);
            // получаем поток байтов по этой ссылке
            InputStream in = new BufferedInputStream(url.openStream());
            // сделаем буфер, который будет хранить изображение
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // массив-буфер
            byte[] buffer = new byte[1024];
            int n;
            while (-1 != (n = in.read(buffer))) {
                out.write(buffer, 0, n);
            }
            out.close();
            in.close();
            // получим само изображение
            byte[] image = out.toByteArray();
            // создаем файл, куда будем записывать
            String newFileName = UUID.randomUUID().toString();
            // записываем все байты в новый файл
            FileOutputStream outputStream = new FileOutputStream("images\\" + newFileName + ".png");
            outputStream.write(image);
            outputStream.close();
            System.out.println("FILE SAVED");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
    // без многопоточности ушло - 63622
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        long before = System.currentTimeMillis();
        try {
            BufferedReader links = new BufferedReader(new FileReader("links.txt"));
            links.lines().forEach(fileUrl -> service.submit(() -> saveFile(fileUrl)));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);
        service.shutdown();
    }
}
