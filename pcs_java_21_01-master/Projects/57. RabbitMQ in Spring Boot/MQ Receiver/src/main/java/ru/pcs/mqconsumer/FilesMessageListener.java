package ru.pcs.mqconsumer;

import lombok.SneakyThrows;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

/**
 * 29.11.2021
 * MQ Receiver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class FilesMessageListener {

    @RabbitListener(queues = "#{queue.name}", containerFactory = "containerFactory")
    public void onMessage(Message message) {
        try {
            String fileUrl = new String(message.getBody());
            URL url = new URL(fileUrl);
            URLConnection urlConnection = url.openConnection();
            long size = urlConnection.getContentLength();
            System.out.println("File " + fileUrl + " size is " + size);
            System.out.println(Thread.currentThread().getName() + " " + (new String(message.getBody())));
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
