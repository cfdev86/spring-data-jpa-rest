package com.cfprac.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"createdDateTime","updatedDateTime","version"})
public class Publisher extends BaseEntity{

    private String name;

    private LocalDate incorporateAt;

    @Version
    private int version;

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.PERSIST)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
        book.setPublisher(this);
    }

}
