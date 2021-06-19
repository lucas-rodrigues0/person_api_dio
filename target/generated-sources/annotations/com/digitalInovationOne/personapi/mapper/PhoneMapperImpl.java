package com.digitalInovationOne.personapi.mapper;

import com.digitalInovationOne.personapi.dto.request.PhoneDTO;
import com.digitalInovationOne.personapi.dto.request.PhoneDTO.PhoneDTOBuilder;
import com.digitalInovationOne.personapi.entity.Phone;
import com.digitalInovationOne.personapi.entity.Phone.PhoneBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-19T14:29:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class PhoneMapperImpl implements PhoneMapper {

    @Override
    public Phone toModel(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.type( phoneDTO.getType() );
        phone.number( phoneDTO.getNumber() );

        return phone.build();
    }

    @Override
    public PhoneDTO toDTO(Phone person) {
        if ( person == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( person.getId() );
        phoneDTO.type( person.getType() );
        phoneDTO.number( person.getNumber() );

        return phoneDTO.build();
    }
}
