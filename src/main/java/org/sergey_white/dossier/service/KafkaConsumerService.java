package org.sergey_white.dossier.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sergey_white.dossier.dto.EmailMessage;
import org.sergey_white.dossier.mapper.JsonMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final JsonMapper jsonMapper;

    @KafkaListener(topics = {"finish-registration", "create-documents", "send-documents", "send-ses",
            "credit-issued", "statement-denied"}, groupId = "dossier-group")
    public void listenMessage(String message) {
        try {
            EmailMessage emailMessage = jsonMapper.toEmailMessage(message);
            log.info("Message received: {}", emailMessage);
            System.out.printf("Идет отправка письма на email : %s\nТекст сообщения : %s ",
                    emailMessage.getAddress(), emailMessage.getText());
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}