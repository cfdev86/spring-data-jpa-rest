package com.cfprac.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

}
