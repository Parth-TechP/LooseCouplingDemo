package com.example.LooseCouplingDemo.service_inteface;

import com.example.LooseCouplingDemo.dto.MessageAdditionDto;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface MessageService {
    List<MessageAdditionDto> getAllMessages();

    MessageAdditionDto getById(Long id) throws ResourceNotFoundException;

    MessageAdditionDto createMessage(MessageAdditionDto messageAdditionDTO);
}
