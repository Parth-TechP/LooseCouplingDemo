package com.example.LooseCouplingDemo.service_inteface;

import com.example.LooseCouplingDemo.dto.MessageAdditionDTO;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface MessageService {
    List<MessageAdditionDTO> getAllMessages();

    MessageAdditionDTO getById(Long id) throws ResourceNotFoundException;

    MessageAdditionDTO createMessage(MessageAdditionDTO messageAdditionDTO);
}
