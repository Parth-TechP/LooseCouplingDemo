package com.example.LooseCouplingDemo.dto;

import lombok.Data;
import com.example.LooseCouplingDemo.model.MessageType;

@Data
public class AddMessagesDTO {
    private MessageType messageType;
    private String content;
}
