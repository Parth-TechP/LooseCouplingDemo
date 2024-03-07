package com.example.LooseCouplingDemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserMessagesDisplayDto {
    private String username;
    private List<MessageAdditionDto> messages;
}
