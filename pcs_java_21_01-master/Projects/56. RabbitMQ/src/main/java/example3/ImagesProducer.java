package example3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 29.10.2021
 * 28. RabbitMQ
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ImagesProducer {

    private static final String EXCHANGE_NAME = "images_exchange";
    private static final String EXCHANGE_TYPE = "fanout";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {

            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
            scanner.nextLine();

            File file = new File("images.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.lines().forEach(url -> {
                try {
                    channel.basicPublish(EXCHANGE_NAME,"", null, url.getBytes());
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            });
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
