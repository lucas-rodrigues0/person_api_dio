package com.digitalInovationOne.personapi.repository;

import com.digitalInovationOne.personapi.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
