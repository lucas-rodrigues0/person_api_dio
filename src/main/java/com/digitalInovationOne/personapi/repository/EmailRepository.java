package com.digitalInovationOne.personapi.repository;

import com.digitalInovationOne.personapi.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
