package com.example.LooseCouplingDemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.util.List;

@Data
public class UserAdditionDTO {
    @NotBlank(message = "Username is mandatory")
    private String username;
    private List<MessageAdditionDTO> messages;
}
