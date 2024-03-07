package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.UserAdditionDto;
import com.example.LooseCouplingDemo.dto.UserDisplayDto;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDto;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;
import com.example.LooseCouplingDemo.service_inteface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;
    @GetMapping
    List<UserDisplayDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    UserDisplayDto getUserById(@PathVariable(value = "id")Long UserId)throws ResourceNotFoundException {
        return userService.getUserById(UserId);
    }

    @GetMapping("/{id}/messages")
    UserMessagesDisplayDto getUserMessages(@PathVariable(value = "id")Long UserId)throws ResourceNotFoundException{return userService.getUserMessages(UserId);}

    @PostMapping
    UserMessagesDisplayDto createUser(@RequestBody UserAdditionDto userAdditionDTO){
        return userService.createUser(userAdditionDTO);
    }
}
