package com.digitalInovationOne.personapi.mapper;

import com.digitalInovationOne.personapi.dto.request.EmailDTO;
import com.digitalInovationOne.personapi.entity.Email;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-19T19:11:27-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class EmailMapperImpl implements EmailMapper {

    @Override
    public Email toModel(EmailDTO emailDTO) {
        if ( emailDTO == null ) {
            return null;
        }

        Email email = new Email();

        email.setId( emailDTO.getId() );
        email.setEmailAddress( emailDTO.getEmailAddress() );

        return email;
    }

    @Override
    public EmailDTO toDTO(Email email) {
        if ( email == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setId( email.getId() );
        emailDTO.setEmailAddress( email.getEmailAddress() );

        return emailDTO;
    }
}
