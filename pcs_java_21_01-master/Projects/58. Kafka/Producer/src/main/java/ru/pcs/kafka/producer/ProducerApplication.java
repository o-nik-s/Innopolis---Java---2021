package ru.pcs.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    public static final String FILES_TOPIC = "files";
    public static final String IMAGES_TOPIC = "images";
    public static final String DOCUMENTS_TOPIC = "documents";

    @Bean
    public NewTopic filesTopic() {
        return new NewTopic(FILES_TOPIC, 3, (short)1);
    }

    @Bean
    public NewTopic images() {
        return new NewTopic(IMAGES_TOPIC, 2, (short)1);
    }

    @Bean
    public NewTopic documents() {
        return new NewTopic(DOCUMENTS_TOPIC, 1, (short)1);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
