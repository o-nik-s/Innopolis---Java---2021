package ru.pcs.mqproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 29.11.2021
 * MQ Producer
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@RestController
public class FilesController {

    private final static String PNG_ROUTING_KEY = "files.images.png";
    private final static String JPG_ROUTING_KEY = "files.images.jpg";
    private final static String PDF_ROUTING_KEY = "files.documents.pdf";
    private final static String HTML_ROUTING_KEY = "files.documents.html";

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/file")
    public ResponseEntity<?> sendFile(@RequestParam("file") String fileName) {
        String currentRouting = fileName.substring(fileName.lastIndexOf("."));

        if (currentRouting.equals(".jpeg")) {
            currentRouting = ".jpg";
        }

        switch (currentRouting) {
            case ".jpg":
                currentRouting = JPG_ROUTING_KEY;
                break;
            case ".png":
                currentRouting = PNG_ROUTING_KEY;
                break;
            case ".html":
                currentRouting = HTML_ROUTING_KEY;
                break;
            default:
                currentRouting = PDF_ROUTING_KEY;
                break;
        }

        rabbitTemplate.send("files_topic_exchange", currentRouting, new Message(fileName.getBytes()));
        return ResponseEntity.ok().build();
    }
}
