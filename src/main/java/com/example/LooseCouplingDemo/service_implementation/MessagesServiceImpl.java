package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.MessageAdditionDto;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;
import com.example.LooseCouplingDemo.mapper.MessagesMapper;
import com.example.LooseCouplingDemo.model.Messages;
import com.example.LooseCouplingDemo.repository.MessagesRepository;
import com.example.LooseCouplingDemo.service_inteface.MessageService;
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
    public List<MessageAdditionDto> getAllMessages() {
        List<Messages> messages = messagesRepository.findAll();
        return messages.stream().map(messagesMapper::convertMessagesToMessageAdditionDTO).collect(Collectors.toList());
     }

    @Override
    public MessageAdditionDto getById(Long id)throws ResourceNotFoundException {
        return messagesMapper.convertMessagesToMessageAdditionDTO(messagesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id)));
    }

    @Override
    public MessageAdditionDto createMessage(MessageAdditionDto messageAdditionDTO) {
        Messages messages = messagesMapper.convertMessageAdditionDtoToMessages(messageAdditionDTO);
        this.messagesRepository.save(messages);
        return messagesMapper.convertMessagesToMessageAdditionDTO(messages);
    }
}
