package com.cfprac.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"createdDateTime","updatedDateTime","version"})
public class Address extends BaseEntity{

    private String country;

    @Version
    private int version;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

}
