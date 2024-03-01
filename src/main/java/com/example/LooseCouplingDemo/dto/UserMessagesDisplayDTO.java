package com.example.LooseCouplingDemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserMessagesDisplayDTO {
    private String username;
    private List<MessageAdditionDTO> messages;
}
