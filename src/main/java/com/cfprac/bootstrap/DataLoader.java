package com.cfprac.bootstrap;

import com.cfprac.constant.Gender;
import com.cfprac.domain.Address;
import com.cfprac.domain.Author;
import com.cfprac.domain.Book;
import com.cfprac.domain.Publisher;
import com.cfprac.repository.AddressRepository;
import com.cfprac.repository.AuthorRepository;
import com.cfprac.repository.BookRepository;
import com.cfprac.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

//Spring will automatically call (after the Spring application context is loaded) the run method of all beans implementing the CommandLineRunner interface
@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setName("James");
        author1.setDob(LocalDate.of(1982,1,2));
        author1.setGender(Gender.M);
        author1.setAge(41);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Oxford Inc.");
        publisher1.setIncorporateAt(LocalDate.of(2020,5,8));

        Book book1 = new Book();
        book1.setTitle("Life in Spring!");
        author1.addBook(book1);
        publisher1.addBook(book1);

        Book book2 = new Book();
        book2.setTitle("Life in Monsoon!");
        author1.addBook(book2);
        publisher1.addBook(book2);

        Address address1 = new Address();
        address1.setCountry("UK");
        address1.setAuthor(author1);
        author1.updateAddress(address1);

        authorRepository.save(author1);
        publisherRepository.save(publisher1);


        Author author2 = new Author();
        author2.setName("Fred");
        author2.setDob(LocalDate.of(1974, 9,22));
        author2.setGender(Gender.M);
        author2.setAge(49);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Orielly Inc.");
        publisher2.setIncorporateAt(LocalDate.of(2001,10,14));

        Book book3 = new Book();
        book3.setTitle("Wonders of Java!");
        author2.addBook(book3);
        publisher2.addBook(book3);

        Book book4 = new Book();
        book4.setTitle("Wonders of Python!");
        author2.addBook(book4);
        publisher2.addBook(book4);

        Address address2 = new Address();
        address2.setCountry("US");
        address2.setAuthor(author2);
        author2.updateAddress(address2);

        authorRepository.save(author2);
        publisherRepository.save(publisher2);

    }

}
