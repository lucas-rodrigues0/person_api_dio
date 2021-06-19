package com.digitalInovationOne.personapi.controller;

import com.digitalInovationOne.personapi.dto.request.PersonDTO;
import com.digitalInovationOne.personapi.dto.request.PhoneDTO;
import com.digitalInovationOne.personapi.dto.response.MessageResponseDTO;
import com.digitalInovationOne.personapi.exception.PersonNotFoundException;
import com.digitalInovationOne.personapi.exception.PhoneNotFoundException;
import com.digitalInovationOne.personapi.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/phone")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    private PhoneService phoneService;

    @PostMapping("/person/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPhone(@PathVariable Long userId, @RequestBody @Valid PhoneDTO phoneDTO) throws PersonNotFoundException {

        return phoneService.createPhone(userId, phoneDTO);
    }

    @GetMapping
    public List<PhoneDTO> listAll() {
        return phoneService.listAll();
    }

    @GetMapping("/{phoneId}")
    public PhoneDTO findById(@PathVariable long phoneId) throws PhoneNotFoundException {
        return phoneService.findById(phoneId);
    }

    @PutMapping("/{phoneId}/person/{userId}")
    public MessageResponseDTO updateById(@PathVariable Long userId, @PathVariable Long phoneId, @RequestBody @Valid PhoneDTO phoneDTO) throws PhoneNotFoundException, PersonNotFoundException {
        return phoneService.updatePhoneById(userId, phoneId, phoneDTO);
    }

    @DeleteMapping("/{phoneId}/person/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long phoneId, @PathVariable long userId) throws PhoneNotFoundException, PersonNotFoundException {
        phoneService.deletePhone(phoneId, userId);
    }

}
