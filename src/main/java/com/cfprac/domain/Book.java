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
public class Book extends BaseEntity{

    private String title;

    @Version
    private int version;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="publisher_id", referencedColumnName = "id")
    private Publisher publisher;

}
