package com.digitalInovationOne.personapi.mapper;


import com.digitalInovationOne.personapi.dto.request.PhoneDTO;
import com.digitalInovationOne.personapi.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toModel(PhoneDTO phoneDTO);

    PhoneDTO toDTO(Phone phone);
}
