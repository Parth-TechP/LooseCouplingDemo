package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.AddMessagesDTO;
import com.example.LooseCouplingDemo.service_Inteface.MessageServiceInterface;
import com.example.LooseCouplingDemo.service_implementation.MessageService;
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
    MessageServiceInterface messageServiceInterface;


//    @Autowired
//    MessageService messageService;
    @GetMapping
    List<AddMessagesDTO> getALlMessages(){
        return messageServiceInterface.getAllMessages();
    }

    @GetMapping("/{id}")
    AddMessagesDTO getById(@PathVariable(value = "id")Long MessageId){
        return messageServiceInterface.getById(MessageId);
    }

    @PostMapping
    AddMessagesDTO createMessage(@Valid @RequestBody AddMessagesDTO addMessagesDTO){
        return messageServiceInterface.createMessage(addMessagesDTO);
    }
}
