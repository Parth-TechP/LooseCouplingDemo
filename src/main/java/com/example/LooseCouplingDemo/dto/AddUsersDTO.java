package com.example.LooseCouplingDemo.dto;

import lombok.Data;


import java.util.List;

@Data
public class AddUsersDTO {
    private String username;
    private List<AddMessagesDTO> messages;
}
