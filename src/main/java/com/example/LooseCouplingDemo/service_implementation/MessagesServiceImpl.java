package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.AddMessagesDTO;
import com.example.LooseCouplingDemo.mapper.MessagesMapper;
import com.example.LooseCouplingDemo.model.Messages;
import com.example.LooseCouplingDemo.repository.MessagesRepository;
import com.example.LooseCouplingDemo.service_Inteface.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("messages")
public class MessagesServiceImpl implements MessageService {

    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    MessagesMapper messagesMapper;

    @Override
    public List<AddMessagesDTO> getAllMessages() {
        List<Messages> messages = messagesRepository.findAll();
        return messages.stream().map(messagesMapper::EntityToDTO).collect(Collectors.toList());
     }

    @Override
    public AddMessagesDTO getById(Long id) {
        return messagesMapper.EntityToDTO(messagesRepository.findById(id).orElseThrow(()-> new RuntimeException("Message not found for Id: "+id)));
    }

    @Override
    public AddMessagesDTO createMessage(AddMessagesDTO addMessagesDTO) {
        Messages messages = messagesMapper.DTOToEntity(addMessagesDTO);
        this.messagesRepository.save(messages);
        return messagesMapper.EntityToDTO(messages);
    }
}
