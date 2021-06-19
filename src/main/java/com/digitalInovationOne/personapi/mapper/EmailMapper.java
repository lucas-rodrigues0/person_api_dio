package com.digitalInovationOne.personapi.mapper;

import com.digitalInovationOne.personapi.dto.request.EmailDTO;
import com.digitalInovationOne.personapi.entity.Email;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    Email toModel(EmailDTO emailDTO);

    EmailDTO toDTO(Email email);
}
