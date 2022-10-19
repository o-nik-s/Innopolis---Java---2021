package ru.pcs.kafka.consumers;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 02.12.2021
 * Consumer
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Profile("files-consumer")
@Component
public class FilesConsumer {

    @KafkaListener(topics = "files", groupId = "filesGroupId")
    public void listenFiles(@Payload String message) {
        System.out.println("Files " + message);
    }
}
