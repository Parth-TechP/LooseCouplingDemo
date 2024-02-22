package com.example.LooseCouplingDemo.service_Inteface;

import com.example.LooseCouplingDemo.dto.AddUsersDTO;
import com.example.LooseCouplingDemo.dto.ShowUserMessages;
import com.example.LooseCouplingDemo.dto.ShowUsersDTO;

import java.util.List;

public interface UserService {
    List<ShowUsersDTO> getAllUsers();

    ShowUsersDTO getUserById(Long id);

    ShowUserMessages getUserMessages(Long id);

    ShowUserMessages createUser(AddUsersDTO addUsersDTO);
}
