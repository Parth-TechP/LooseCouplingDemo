package com.example.LooseCouplingDemo.service_Inteface;

import com.example.LooseCouplingDemo.dto.AddMessagesDTO;

import java.util.List;

public interface MessageService {
    List<AddMessagesDTO> getAllMessages();

    AddMessagesDTO getById(Long id);

    AddMessagesDTO createMessage(AddMessagesDTO addMessagesDTO);
}
