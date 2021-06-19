package com.digitalInovationOne.personapi.service;

import com.digitalInovationOne.personapi.dto.request.EmailDTO;
import com.digitalInovationOne.personapi.dto.request.PhoneDTO;
import com.digitalInovationOne.personapi.dto.response.MessageResponseDTO;
import com.digitalInovationOne.personapi.entity.Email;
import com.digitalInovationOne.personapi.entity.Person;
import com.digitalInovationOne.personapi.entity.Phone;
import com.digitalInovationOne.personapi.exception.EmailNotFoundException;
import com.digitalInovationOne.personapi.exception.PersonNotFoundException;
import com.digitalInovationOne.personapi.exception.PhoneNotFoundException;
import com.digitalInovationOne.personapi.mapper.EmailMapper;
import com.digitalInovationOne.personapi.mapper.PhoneMapper;
import com.digitalInovationOne.personapi.repository.EmailRepository;
import com.digitalInovationOne.personapi.repository.PersonRepository;
import com.digitalInovationOne.personapi.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {
    private PersonRepository personRepository;
    private EmailRepository emailRepository;

    private final EmailMapper emailMapper = EmailMapper.INSTANCE;

    public MessageResponseDTO createEmail(Long id, EmailDTO emailDTO) throws PersonNotFoundException {
        Person personTosave = verifyIfPersonExists(id);
        Email emailTosave = emailMapper.toModel(emailDTO);
        List<Email> emails = personTosave.getEmails();
        emails.add(emailTosave);
        personTosave.setEmails(emails);
        Person savedPerson = personRepository.save(personTosave);
        return createMessageResponse(savedPerson.getId(), "Create email for user with ID ");
    }

    public List<EmailDTO> listAllEmails() {
        List<Email> allEmails = emailRepository.findAll();
        return allEmails.stream()
                .map(emailMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmailDTO findById(long emailId) throws EmailNotFoundException {
        Email email = verifyIfEmailExists(emailId);

        return emailMapper.toDTO(email);
    }

    public MessageResponseDTO updateEmailById(Long userId, Long emailId, EmailDTO emailDTO) throws PersonNotFoundException, EmailNotFoundException {
        verifyIfEmailExists(emailId);
        Person personToUpdate = verifyIfPersonExists(userId);
        List<Email> personEmails = personToUpdate.getEmails();

        for (Email email : personEmails) {
            if (email.getId() == emailId) {
                email.setEmailAddress(emailDTO.getEmailAddress());
            }
        }

        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(savedPerson.getId(), "Updated email for user with ID ");
    }

    public void deleteEmail(Long emailId, Long userId) throws EmailNotFoundException, PersonNotFoundException {
        verifyIfEmailExists(emailId);
        Person toRemoveEmail = verifyIfPersonExists(userId);
        List<Email> personEmails = toRemoveEmail.getEmails();
        List<Email> newPersonEmails = new ArrayList<Email>();
        for (Email email : personEmails) {
            if (email.getId() != emailId) {
                newPersonEmails.add(email);
            }
        }
        toRemoveEmail.setEmails(newPersonEmails);

        emailRepository.deleteById(emailId);
    }

    private Email verifyIfEmailExists(long emailId) throws EmailNotFoundException {
        return  emailRepository.findById(emailId)
                .orElseThrow(() -> new EmailNotFoundException(emailId));
    }

    private Person verifyIfPersonExists(long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
