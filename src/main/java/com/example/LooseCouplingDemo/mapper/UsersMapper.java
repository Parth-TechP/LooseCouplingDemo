package com.example.LooseCouplingDemo.mapper;

import com.example.LooseCouplingDemo.dto.UserAdditionDto;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDto;
import com.example.LooseCouplingDemo.dto.UserDisplayDto;
import com.example.LooseCouplingDemo.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MessagesMapper.class )
public interface UsersMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "messages", target = "messages")
    Users convertUsersAddtionDtoToUsers(UserAdditionDto userAdditionDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    UserDisplayDto convertUsersToUserDisplayDto(Users users);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "messages", target = "messages")
    UserMessagesDisplayDto convertUsersToUserMessagesDisplayDto(Users users);
}
