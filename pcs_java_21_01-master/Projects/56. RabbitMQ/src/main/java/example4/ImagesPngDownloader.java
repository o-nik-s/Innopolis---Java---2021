package example4;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

/**
 * 29.10.2021
 * 28. RabbitMQ
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ImagesPngDownloader {

    private static final String PNG_QUEUE = "images_png_queue";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(3);
            channel.basicConsume(PNG_QUEUE, false, (consumerTag, message) -> {
                String imageUrl = new String(message.getBody());
                System.out.println(Thread.currentThread() + " start download" + imageUrl);
                URL url = new URL(imageUrl);
                String fileName = url.getFile();
                try {
                    BufferedImage image = ImageIO.read(url);

                    // конвертируем png -> jpg с заменой альфа-канала розовым цветом
                    BufferedImage converted = new BufferedImage(
                            image.getWidth(),
                            image.getHeight(),
                            BufferedImage.TYPE_INT_RGB);
                    converted.createGraphics().drawImage(image, 0, 0, Color.PINK, null);

                    File output = new File("downloaded/" + UUID.randomUUID() +
                            fileName.substring(fileName.lastIndexOf(".")));
                    ImageIO.write(converted, "jpg", output);
                    System.out.println("Finish load image " + imageUrl);
                    // подтвердить, что сообщение обработано
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                } catch (IOException e) {
                    System.err.println("FAILED");
                    channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
                }
            }, consumerTag -> {});
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
