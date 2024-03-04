package com.example.LooseCouplingDemo.service_inteface;

import com.example.LooseCouplingDemo.dto.UserAdditionDTO;
import com.example.LooseCouplingDemo.dto.UserDisplayDTO;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDTO;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    List<UserDisplayDTO> getAllUsers();

    UserDisplayDTO getUserById(Long id) throws ResourceNotFoundException;

    UserMessagesDisplayDTO getUserMessages(Long id) throws ResourceNotFoundException;

    UserMessagesDisplayDTO createUser(UserAdditionDTO userAdditionDTO);
}
