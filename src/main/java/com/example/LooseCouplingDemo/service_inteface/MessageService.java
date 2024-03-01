package com.example.LooseCouplingDemo.service_inteface;

import com.example.LooseCouplingDemo.dto.MessageAdditionDTO;

import java.util.List;

public interface MessageService {
    List<MessageAdditionDTO> getAllMessages();

    MessageAdditionDTO getById(Long id);

    MessageAdditionDTO createMessage(MessageAdditionDTO messageAdditionDTO);
}
