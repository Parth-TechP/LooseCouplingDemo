package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.MessageAdditionDTO;
import com.example.LooseCouplingDemo.dto.UserDisplayDTO;
import com.example.LooseCouplingDemo.mapper.MessagesMapper;
import com.example.LooseCouplingDemo.model.Messages;
import com.example.LooseCouplingDemo.model.Users;
import com.example.LooseCouplingDemo.repository.MessagesRepository;
import com.example.LooseCouplingDemo.service_inteface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    MessagesMapper messagesMapper;

    @Autowired
    UserService userService;


    public List<MessageAdditionDTO> getAllMessages() {
        List<Messages> messages = messagesRepository.findAll();
        return messages.stream().map(messagesMapper::convertMessagesToMessageAdditionDTO).collect(Collectors.toList());
    }


    public MessageAdditionDTO getById(Long id) {
        return messagesMapper.convertMessagesToMessageAdditionDTO(messagesRepository.findById(id).orElseThrow(()-> new RuntimeException("Message not found for Id: "+id)));
    }


    public MessageAdditionDTO createMessage(MessageAdditionDTO messageAdditionDTO) {
        Messages messages = messagesMapper.convertMessageAdditionDtoToMessages(messageAdditionDTO);
        this.messagesRepository.save(messages);
//        List<UserDisplayDTO> userDisplayDTOS= userService.getAllUsers();
        return messagesMapper.convertMessagesToMessageAdditionDTO(messages);
    }
}
