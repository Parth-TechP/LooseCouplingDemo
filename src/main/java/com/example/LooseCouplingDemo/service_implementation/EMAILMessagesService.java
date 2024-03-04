package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.MessageAdditionDTO;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;
import com.example.LooseCouplingDemo.mapper.MessagesMapper;
import com.example.LooseCouplingDemo.model.Messages;
import com.example.LooseCouplingDemo.repository.MessagesRepository;
import com.example.LooseCouplingDemo.service_inteface.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("email")
public class EMAILMessagesService implements MessageService {

    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    MessagesMapper messagesMapper;

    String messageType = "EMAIL";
    @Override
    public List<MessageAdditionDTO> getAllMessages() {
        List<Messages> messages = messagesRepository.findAllByTypeIgnoreCase(messageType);
        return messages.stream().map(messagesMapper::convertMessagesToMessageAdditionDTO).collect(Collectors.toList());
    }

    @Override
    public MessageAdditionDTO getById(Long id)throws ResourceNotFoundException {
        List<Messages> messages = messagesRepository.findAllByTypeIgnoreCase(messageType);
        Messages messageById = null;
        for(Messages messages1: messages){
            if (messages1.getId() == id){
                messageById = messages1;
                break;
            }
        }
        if (messageById != null) {
            return messagesMapper.convertMessagesToMessageAdditionDTO(messageById);
        } else {
            throw new ResourceNotFoundException(id);
        }
        //return messagesMapper.convertMessagesToMessageAdditionDTO(messages.stream().filter(messages1 -> messages1.getId() == id).findFirst().orElseThrow(()-> new RuntimeException("Message not found for Id: "+id)));
    }

    @Override
    public MessageAdditionDTO createMessage(MessageAdditionDTO messageAdditionDTO) {
        Messages messages = messagesMapper.convertMessageAdditionDtoToMessages(messageAdditionDTO);
        this.messagesRepository.save(messages);
        return messagesMapper.convertMessagesToMessageAdditionDTO(messages);
    }
}
