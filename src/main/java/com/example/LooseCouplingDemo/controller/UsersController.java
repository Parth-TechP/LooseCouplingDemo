package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.UserAdditionDTO;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDTO;
import com.example.LooseCouplingDemo.dto.UserDisplayDTO;
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
    List<UserDisplayDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    UserDisplayDTO getUserById(@PathVariable(value = "id")Long UserId){
        return userService.getUserById(UserId);
    }

    @GetMapping("/{id}/messages")
    UserMessagesDisplayDTO getUserMessages(@PathVariable(value = "id")Long UserId){return userService.getUserMessages(UserId);}

    @PostMapping
    UserMessagesDisplayDTO createUser(@RequestBody UserAdditionDTO userAdditionDTO){
        return userService.createUser(userAdditionDTO);
    }
}
