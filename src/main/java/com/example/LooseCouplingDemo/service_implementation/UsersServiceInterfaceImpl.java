package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.AddUsersDTO;
import com.example.LooseCouplingDemo.dto.ShowUserMessages;
import com.example.LooseCouplingDemo.dto.ShowUsersDTO;
import com.example.LooseCouplingDemo.mapper.UsersMapper;
import com.example.LooseCouplingDemo.model.Users;
import com.example.LooseCouplingDemo.repository.UserRepository;
import com.example.LooseCouplingDemo.service_Inteface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UsersServiceInterfaceImpl implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UsersMapper usersMapper;

    @Override
    public List<ShowUsersDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(usersMapper::showUsersDTOMapper).collect(Collectors.toList());
    }

    @Override
    public ShowUsersDTO getUserById(Long id) {
        return usersMapper.showUsersDTOMapper(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with Id: "+id)));
    }

    @Override
    public ShowUserMessages getUserMessages(Long id) {
        return usersMapper.showUserMessagesDTOMapper(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with Id: "+id)));
    }

    @Override
    public ShowUserMessages createUser(AddUsersDTO addUsersDTO) {
        Users users = usersMapper.DTOToEntity(addUsersDTO);
        this.userRepository.save(users);
        return usersMapper.showUserMessagesDTOMapper(users);
    }
}
