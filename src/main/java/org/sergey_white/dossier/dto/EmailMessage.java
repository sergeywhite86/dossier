package org.sergey_white.dossier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.sergey_white.dossier.enums.ApplicationStatus;

import java.util.UUID;


@Data
public class EmailMessage {
    @JsonProperty("address")
    private String address;
    @JsonProperty("theme")
    private ApplicationStatus theme;
    @JsonProperty("statementId")
    private UUID statementId;
    @JsonProperty("text")
    private String text;
}
