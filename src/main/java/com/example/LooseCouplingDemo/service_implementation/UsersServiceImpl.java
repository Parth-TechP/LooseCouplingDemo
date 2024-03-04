package com.example.LooseCouplingDemo.service_implementation;

import com.example.LooseCouplingDemo.dto.UserAdditionDto;
import com.example.LooseCouplingDemo.dto.UserDisplayDto;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDto;
import com.example.LooseCouplingDemo.exceptions.ResourceNotFoundException;
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
    public List<UserDisplayDto> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(usersMapper::convertUsersToUserDisplayDto).collect(Collectors.toList());
    }

    @Override
    public UserDisplayDto getUserById(Long id)throws ResourceNotFoundException {
        return usersMapper.convertUsersToUserDisplayDto(userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id)));
    }

    @Override
    public UserMessagesDisplayDto getUserMessages(Long id)throws ResourceNotFoundException {
        return usersMapper.convertUsersToUserMessagesDisplayDto(userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id)));
    }

    @Override
    public UserMessagesDisplayDto createUser(UserAdditionDto userAdditionDTO) {
        Users users = usersMapper.convertUsersAddtionDtoToUsers(userAdditionDTO);
        this.userRepository.save(users);
        return usersMapper.convertUsersToUserMessagesDisplayDto(users);
    }
}
