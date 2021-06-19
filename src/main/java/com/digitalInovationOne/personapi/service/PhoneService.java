package com.digitalInovationOne.personapi.service;

import com.digitalInovationOne.personapi.dto.request.PersonDTO;
import com.digitalInovationOne.personapi.dto.request.PhoneDTO;
import com.digitalInovationOne.personapi.dto.response.MessageResponseDTO;
import com.digitalInovationOne.personapi.entity.Person;
import com.digitalInovationOne.personapi.entity.Phone;
import com.digitalInovationOne.personapi.exception.PersonNotFoundException;
import com.digitalInovationOne.personapi.exception.PhoneNotFoundException;
import com.digitalInovationOne.personapi.mapper.PersonMapper;
import com.digitalInovationOne.personapi.mapper.PhoneMapper;
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
public class PhoneService {

    private PersonRepository personRepository;
    private PhoneRepository phoneRepository;

    private final PhoneMapper phoneMapper = PhoneMapper.INSTANCE;

    public MessageResponseDTO createPhone(Long id, PhoneDTO phoneDTO) throws PersonNotFoundException {
        Person personTosave = verifyIfPersonExists(id);
        Phone phoneTosave = phoneMapper.toModel(phoneDTO);
        List<Phone> phones = personTosave.getPhones();
        phones.add(phoneTosave);
        personTosave.setPhones(phones);
        Person savedPerson = personRepository.save(personTosave);
        return createMessageResponse(savedPerson.getId(), "Create phone for user with ID ");
    }

    public List<PhoneDTO> listAll() {
        List<Phone> allPhones = phoneRepository.findAll();
        return allPhones.stream()
                .map(phoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PhoneDTO findById(long phoneId) throws PhoneNotFoundException {
        Phone phone = verifyIfPhoneExists(phoneId);

        return phoneMapper.toDTO(phone);
    }

    public MessageResponseDTO updatePhoneById(Long userId, Long phoneId, PhoneDTO phoneDTO) throws PersonNotFoundException, PhoneNotFoundException {
        verifyIfPhoneExists(phoneId);
        Person personToUpdate = verifyIfPersonExists(userId);
        List<Phone> personPhones = personToUpdate.getPhones();

        for (Phone phone : personPhones) {
            if (phone.getId() == phoneId) {
                phone.setType(phoneDTO.getType());
                phone.setNumber(phoneDTO.getNumber());
            }
        }

        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(savedPerson.getId(), "Updated phone for user with ID ");
    }

    public void deletePhone(Long phoneId, Long userId) throws PhoneNotFoundException, PersonNotFoundException {
        verifyIfPhoneExists(phoneId);
        Person toRemovePhone = verifyIfPersonExists(userId);
        List<Phone> personPhones = toRemovePhone.getPhones();
        List<Phone> newPersonPhones = new ArrayList<Phone>();
        for (Phone phone : personPhones) {
            if (phone.getId() != phoneId) {
                newPersonPhones.add(phone);
            }
        }
        toRemovePhone.setPhones(newPersonPhones);

        phoneRepository.deleteById(phoneId);
    }

    private Phone verifyIfPhoneExists(long phoneId) throws PhoneNotFoundException {
        return  phoneRepository.findById(phoneId)
                .orElseThrow(() -> new PhoneNotFoundException(phoneId));
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
