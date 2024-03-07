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

@Service("sms")
public class SMSMessagesService implements MessageService {

    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    MessagesMapper messagesMapper;

    String messageType = "SMS";
    @Override
    public List<MessageAdditionDto> getAllMessages() {
        List<Messages> messages = messagesRepository.findAllByTypeIgnoreCase(messageType);
        return messages.stream().map(messagesMapper::convertMessagesToMessageAdditionDTO).collect(Collectors.toList());
    }

    @Override
    public MessageAdditionDto getById(Long id) throws ResourceNotFoundException {
        Messages messages = messagesRepository.findAllByTypeIgnoreCaseAndId(messageType, id);
        if (messages != null) {
            return messagesMapper.convertMessagesToMessageAdditionDTO(messages);
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public MessageAdditionDto createMessage(MessageAdditionDto messageAdditionDTO) {
        Messages messages = messagesMapper.convertMessageAdditionDtoToMessages(messageAdditionDTO);
        this.messagesRepository.save(messages);
        return messagesMapper.convertMessagesToMessageAdditionDTO(messages);
    }
}
