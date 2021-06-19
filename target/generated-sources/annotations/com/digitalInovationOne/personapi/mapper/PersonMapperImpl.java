package com.digitalInovationOne.personapi.mapper;

import com.digitalInovationOne.personapi.dto.request.EmailDTO;
import com.digitalInovationOne.personapi.dto.request.PersonDTO;
import com.digitalInovationOne.personapi.dto.request.PhoneDTO;
import com.digitalInovationOne.personapi.entity.Email;
import com.digitalInovationOne.personapi.entity.Person;
import com.digitalInovationOne.personapi.entity.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-19T19:11:27-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        if ( personDTO.getBirthDate() != null ) {
            person.setBirthDate( LocalDate.parse( personDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.setId( personDTO.getId() );
        person.setFirstName( personDTO.getFirstName() );
        person.setLastName( personDTO.getLastName() );
        person.setCpf( personDTO.getCpf() );
        person.setPhones( phoneDTOListToPhoneList( personDTO.getPhones() ) );
        person.setEmails( emailDTOListToEmailList( personDTO.getEmails() ) );

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setCpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDTO.setPhones( phoneListToPhoneDTOList( person.getPhones() ) );
        personDTO.setEmails( emailListToEmailDTOList( person.getEmails() ) );

        return personDTO;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setType( phoneDTO.getType() );
        phone.setNumber( phoneDTO.getNumber() );

        return phone;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected Email emailDTOToEmail(EmailDTO emailDTO) {
        if ( emailDTO == null ) {
            return null;
        }

        Email email = new Email();

        email.setId( emailDTO.getId() );
        email.setEmailAddress( emailDTO.getEmailAddress() );

        return email;
    }

    protected List<Email> emailDTOListToEmailList(List<EmailDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Email> list1 = new ArrayList<Email>( list.size() );
        for ( EmailDTO emailDTO : list ) {
            list1.add( emailDTOToEmail( emailDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setType( phone.getType() );
        phoneDTO.setNumber( phone.getNumber() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }

    protected EmailDTO emailToEmailDTO(Email email) {
        if ( email == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setId( email.getId() );
        emailDTO.setEmailAddress( email.getEmailAddress() );

        return emailDTO;
    }

    protected List<EmailDTO> emailListToEmailDTOList(List<Email> list) {
        if ( list == null ) {
            return null;
        }

        List<EmailDTO> list1 = new ArrayList<EmailDTO>( list.size() );
        for ( Email email : list ) {
            list1.add( emailToEmailDTO( email ) );
        }

        return list1;
    }
}
