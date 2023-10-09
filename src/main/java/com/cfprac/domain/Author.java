package com.cfprac.domain;

import com.cfprac.constant.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dob;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Transient
    private int booksWritten;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
    private Address address;

    public void addBook(Book book){
        books.add(book);
        book.setAuthor(this);
    }

    public void updateAddress(Address address){
        this.address=address;
        address.setAuthor(this);
    }

}
