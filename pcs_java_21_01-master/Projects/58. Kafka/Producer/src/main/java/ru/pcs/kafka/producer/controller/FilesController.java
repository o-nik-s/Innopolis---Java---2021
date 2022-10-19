package ru.pcs.kafka.producer.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static ru.pcs.kafka.producer.ProducerApplication.*;

/**
 * 02.12.2021
 * Producer
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@RestController
public class FilesController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/files")
    public ResponseEntity<?> sendFile(@RequestParam("fileName") String fileName) {
        ListenableFutureCallback<SendResult<String, String>> callback = new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(@NonNull Throwable ex) {
                throw new IllegalArgumentException(ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                Objects.requireNonNull(result);
                System.out.println(result.getProducerRecord().value() + "  " + result.getRecordMetadata().toString());
            }
        };

        ListenableFuture<SendResult<String, String>> fileSendResult = kafkaTemplate.send(FILES_TOPIC, fileName);

        fileSendResult.addCallback(callback);

        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
            ListenableFuture<SendResult<String, String>> imageSendResult = kafkaTemplate.send(IMAGES_TOPIC, fileName);
            imageSendResult.addCallback(callback);
        } else {
            ListenableFuture<SendResult<String, String>> documentsSendResult = kafkaTemplate.send(DOCUMENTS_TOPIC, fileName);
            documentsSendResult.addCallback(callback);
        }

        return ResponseEntity.ok().build();
    }

}
