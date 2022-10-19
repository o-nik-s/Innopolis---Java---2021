package example1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 29.10.2021
 * 28. RabbitMQ
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Consumer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            channel.basicConsume("queue_1", true, (consumerTag, message) -> {
                System.out.println(consumerTag);
                System.out.println(new String(message.getBody()));
            }, consumerTag -> {});
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
