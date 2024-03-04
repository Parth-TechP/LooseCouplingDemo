package com.example.LooseCouplingDemo.service_inteface;

import com.example.LooseCouplingDemo.dto.UserAdditionDto;
import com.example.LooseCouplingDemo.dto.UserDisplayDto;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDto;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    List<UserDisplayDto> getAllUsers();

    UserDisplayDto getUserById(Long id) throws ResourceNotFoundException;

    UserMessagesDisplayDto getUserMessages(Long id) throws ResourceNotFoundException;

    UserMessagesDisplayDto createUser(UserAdditionDto userAdditionDTO);
}
