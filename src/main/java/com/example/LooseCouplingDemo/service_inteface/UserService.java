package com.example.LooseCouplingDemo.service_inteface;

import com.example.LooseCouplingDemo.dto.UserAdditionDTO;
import com.example.LooseCouplingDemo.dto.UserDisplayDTO;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDTO;

import java.util.List;

public interface UserService {
    List<UserDisplayDTO> getAllUsers();

    UserDisplayDTO getUserById(Long id);

    UserMessagesDisplayDTO getUserMessages(Long id);

    UserMessagesDisplayDTO createUser(UserAdditionDTO userAdditionDTO);
}
