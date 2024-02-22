package com.example.LooseCouplingDemo.mapper;

import com.example.LooseCouplingDemo.dto.AddMessagesDTO;
import com.example.LooseCouplingDemo.model.Messages;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsersMapper.class)
public interface MessagesMapper {

    @Mapping(source = "content", target = "content")
    @Mapping(source = "messageType", target = "messageType")
    Messages DTOToEntity(AddMessagesDTO addMessagesDTO);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "messageType", target = "messageType")
    List<Messages> DTOToEntityList(List<AddMessagesDTO> addMessagesDTOS);

    @InheritInverseConfiguration
    List<AddMessagesDTO> EntityToDTOList(List<Messages> messages);
}
