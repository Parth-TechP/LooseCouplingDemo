package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.MessageAdditionDTO;
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
    List<MessageAdditionDTO> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    MessageAdditionDTO getById(@PathVariable(value = "id")Long MessageId){
        return messageService.getById(MessageId);
    }

    @PostMapping
    MessageAdditionDTO createMessage(@Valid @RequestBody MessageAdditionDTO messageAdditionDTO){
        return messageService.createMessage(messageAdditionDTO);
    }
}
