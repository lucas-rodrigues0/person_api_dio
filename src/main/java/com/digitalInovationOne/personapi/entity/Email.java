package com.digitalInovationOne.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailAddress;

    @ManyToOne
    @JoinTable(name = "personID_emailID",
            joinColumns={@JoinColumn(name = "emailID")},
            inverseJoinColumns={@JoinColumn(name = "personID")})
    private Person person;
}
