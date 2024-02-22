package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.AddMessagesDTO;
import com.example.LooseCouplingDemo.service_Inteface.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    @Qualifier("sms")
    MessageService messageService;

    @GetMapping
    List<AddMessagesDTO> getALlMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    AddMessagesDTO getById(@PathVariable(value = "id")Long MessageId){
        return messageService.getById(MessageId);
    }

    @PostMapping
    AddMessagesDTO createMessage(@Valid @RequestBody AddMessagesDTO addMessagesDTO){
        return messageService.createMessage(addMessagesDTO);
    }
}
