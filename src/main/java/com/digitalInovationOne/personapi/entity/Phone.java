package com.digitalInovationOne.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.digitalInovationOne.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

    @ManyToOne
    @JoinTable(name = "personID_phoneID",
            joinColumns={@JoinColumn(name = "phoneID")},
            inverseJoinColumns={@JoinColumn(name = "personID")})
    private Person person;
}
