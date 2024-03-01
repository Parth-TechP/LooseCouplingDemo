package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.UserAdditionDTO;
import com.example.LooseCouplingDemo.dto.UserDisplayDTO;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDTO;
import com.example.LooseCouplingDemo.mapper.UsersMapper;
import com.example.LooseCouplingDemo.model.Users;
import com.example.LooseCouplingDemo.repository.UserRepository;
import com.example.LooseCouplingDemo.service_inteface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UsersServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UsersMapper usersMapper;

    @Override
    public List<UserDisplayDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(usersMapper::convertUsersToUserDisplayDto).collect(Collectors.toList());
    }

    @Override
    public UserDisplayDTO getUserById(Long id) {
        return usersMapper.convertUsersToUserDisplayDto(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with Id: "+id)));
    }

    @Override
    public UserMessagesDisplayDTO getUserMessages(Long id) {
        return usersMapper.convertUsersToUserMessagesDisplayDto(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with Id: "+id)));
    }

    @Override
    public UserMessagesDisplayDTO createUser(UserAdditionDTO userAdditionDTO) {
        Users users = usersMapper.convertUsersAddtionDtoToUsers(userAdditionDTO);
        this.userRepository.save(users);
        return usersMapper.convertUsersToUserMessagesDisplayDto(users);
    }
}
