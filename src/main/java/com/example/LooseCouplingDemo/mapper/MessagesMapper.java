package com.example.LooseCouplingDemo.mapper;

import com.example.LooseCouplingDemo.dto.MessageAdditionDTO;
import com.example.LooseCouplingDemo.model.Messages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsersMapper.class)
public interface MessagesMapper {

    @Mapping(source = "content", target = "content")
    @Mapping(source = "type", target = "type")
    Messages convertMessageAdditionDtoToMessages(MessageAdditionDTO messageAdditionDTO);

    MessageAdditionDTO convertMessagesToMessageAdditionDTO(Messages messages);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "type", target = "type")
    List<Messages> convertListOfMessageAdditionDtoToListOfMessages(List<MessageAdditionDTO> messageAdditionDTOS);
        
    List<MessageAdditionDTO> convertListOfMessagesToListOfMessageAdditionDto(List<Messages> messages);
}
