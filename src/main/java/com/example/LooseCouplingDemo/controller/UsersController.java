package com.example.LooseCouplingDemo.controller;

import com.example.LooseCouplingDemo.dto.AddUsersDTO;
import com.example.LooseCouplingDemo.dto.ShowUserMessages;
import com.example.LooseCouplingDemo.dto.ShowUsersDTO;
import com.example.LooseCouplingDemo.service_Inteface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserServiceInterface usersService;
    @GetMapping
    List<ShowUsersDTO> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    ShowUsersDTO getUserById(@PathVariable(value = "id")Long UserId){
        return usersService.getUserById(UserId);
    }

    @GetMapping("/{id}/messages")
    ShowUserMessages getUserMessages(@PathVariable(value = "id")Long UserId){return usersService.getUserMessages(UserId);}

    @PostMapping
    ShowUserMessages createUser(@RequestBody AddUsersDTO addUsersDTO){
        return usersService.createUser(addUsersDTO);
    }
}
