package org.sergey_white.dossier.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sergey_white.dossier.dto.EmailMessage;
import org.springframework.stereotype.Component;

@Component
public class JsonMapper {
    public EmailMessage toEmailMessage(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, EmailMessage.class);
    }
}
