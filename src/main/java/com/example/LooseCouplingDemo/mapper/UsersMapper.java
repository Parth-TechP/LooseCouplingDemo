package com.example.LooseCouplingDemo.mapper;

import com.example.LooseCouplingDemo.dto.UserAdditionDTO;
import com.example.LooseCouplingDemo.dto.UserMessagesDisplayDTO;
import com.example.LooseCouplingDemo.dto.UserDisplayDTO;
import com.example.LooseCouplingDemo.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MessagesMapper.class )
public interface UsersMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "messages", target = "messages")
    Users convertUsersAddtionDtoToUsers(UserAdditionDTO userAdditionDTO);

    @Mapping(source = "username", target = "username")
    UserDisplayDTO convertUsersToUserDisplayDto(Users users);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "messages", target = "messages")
    UserMessagesDisplayDTO convertUsersToUserMessagesDisplayDto(Users users);
}
