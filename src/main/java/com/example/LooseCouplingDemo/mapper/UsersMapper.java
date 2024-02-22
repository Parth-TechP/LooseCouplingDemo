package com.example.LooseCouplingDemo.mapper;

import com.example.LooseCouplingDemo.dto.AddUsersDTO;
import com.example.LooseCouplingDemo.dto.ShowUserMessages;
import com.example.LooseCouplingDemo.dto.ShowUsersDTO;
import com.example.LooseCouplingDemo.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MessagesMapper.class )
public interface UsersMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "messages", target = "messages")
    Users DTOToEntity(AddUsersDTO addUsersDTO);

    @Mapping(source = "username", target = "username")
    ShowUsersDTO showUsersDTOMapper(Users users);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "messages", target = "messages")
    ShowUserMessages showUserMessagesDTOMapper(Users users);
}
