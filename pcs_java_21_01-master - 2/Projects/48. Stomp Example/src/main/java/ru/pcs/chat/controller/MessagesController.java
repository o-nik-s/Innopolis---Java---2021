package ru.pcs.chat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.pcs.chat.MessageDto;

/**
 * 17.11.2021
 * 48. Stomp Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class MessagesController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private ObjectMapper mapper;

    @MessageMapping("/news")
    public void receiveMessageFromClient(Message<String> message) {
        System.out.println(message.getPayload());
        try {
            MessageDto messageDto = mapper.readValue(message.getPayload(), MessageDto.class);
            template.convertAndSend("/messages", mapper.writeValueAsString(MessageDto.builder()
                    .message("NEWS: " + messageDto.getMessage()).build()));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
