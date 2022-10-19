package example3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

/**
 * 29.10.2021
 * 28. RabbitMQ
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ImagesDownloader {

    private static final String EXCHANGE_NAME = "images_exchange";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(3);
            // создал анонимную очередь
            String queue = channel.queueDeclare().getQueue();
            // привязываю очередь к конкретному EXCHANGE
            channel.queueBind(queue, EXCHANGE_NAME, "");
            scanner.nextLine();
            DeliverCallback callback = (consumerTag, message) -> {
                String imageUrl = new String(message.getBody());
                System.out.println(Thread.currentThread() + " start download" + imageUrl);
                URL url = new URL(imageUrl);
                String fileName = url.getFile();
                try {
                    BufferedImage image = ImageIO.read(url);
                    File output = new File("downloaded/" + UUID.randomUUID() +
                            fileName.substring(fileName.lastIndexOf(".")));
                    ImageIO.write(image, "jpg", output);
                    System.out.println("Finish load image " + imageUrl);
                    // подтвердить, что сообщение обработано
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                } catch (IOException e) {
                    System.err.println("FAILED");
                    channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
                }
            };

            channel.basicConsume(queue, false, callback, consumerTag -> {});
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
