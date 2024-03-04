package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.MessageAdditionDto;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;
import com.example.LooseCouplingDemo.service_inteface.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    @Qualifier("email")
    MessageService messageService;


//    @Autowired
//    MessageService messageService;
    @GetMapping
    List<MessageAdditionDto> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    MessageAdditionDto getById(@PathVariable(value = "id")Long MessageId)throws ResourceNotFoundException {
        return messageService.getById(MessageId);
    }

    @PostMapping
    MessageAdditionDto createMessage(@Valid @RequestBody MessageAdditionDto messageAdditionDTO){
        return messageService.createMessage(messageAdditionDTO);
    }
}
