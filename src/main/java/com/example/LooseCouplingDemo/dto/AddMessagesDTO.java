package com.example.LooseCouplingDemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddMessagesDTO {
    @NotBlank(message = "Message type is mandatory")
    private String messageType;
    @NotBlank(message = "Content is mandatory")
    private String content;
}
