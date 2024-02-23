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
    @Mapping(source = "type", target = "type")
    Messages DTOToEntity(AddMessagesDTO addMessagesDTO);

    @InheritInverseConfiguration
    AddMessagesDTO EntityToDTO(Messages messages);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "type", target = "type")
    List<Messages> DTOToEntityList(List<AddMessagesDTO> addMessagesDTOS);

    @InheritInverseConfiguration
    List<AddMessagesDTO> EntityToDTOList(List<Messages> messages);
}
