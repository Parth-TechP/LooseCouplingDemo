package com.example.LooseCouplingDemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShowUserMessages {
    private String username;
    private List<AddMessagesDTO> messages;
}
