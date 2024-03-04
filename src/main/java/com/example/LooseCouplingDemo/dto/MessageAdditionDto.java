package com.example.LooseCouplingDemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageAdditionDto {
    @NotBlank(message = "Message type is mandatory")
    private String type;
    @NotBlank(message = "Content is mandatory")
    private String content;
}
