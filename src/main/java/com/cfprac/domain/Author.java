package com.cfprac.domain;

import com.cfprac.constant.Gender;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"updatedDateTime","version"})
//Will only include Non-null properties
@JsonInclude(JsonInclude.Include.NON_NULL)
//Will only include Non-null and Non-empty properties
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonPropertyOrder({"id","name","dateOfBirth","gender","booksWritten","books","address"})
//@JsonTypeName and @JsonTypeInfo can be used together to wrap the object in {} and it give it a name -> {name:{object_json}}
//@JsonTypeName("Author")
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use=JsonTypeInfo.Id.NAME)
//@JsonRootName can also be used to wrap the object, but it needs to be used with ObjectMapper that has SerializationFeature.WRAP_ROOT_VALUE enabled
//@JsonRootName("Author")
public class Author extends BaseEntity{

    //@JsonAlias defines one or more alternative names for a property during deserialization
    @JsonAlias({"fullName","name","fName"})
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("dateOfBirth")
    private LocalDate dob;

    @JsonIgnore
    private int age;

    //Iterates the version for each update
    @Version
    private int version;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Transient
    private int booksWritten;

    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @JsonManagedReference
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

    //Can be used to add custom logic before returning value for the property
    @JsonGetter("booksWritten")
    public int getNoOfBooks(){
        return books!=null? books.size(): 0;
    }

    //Can be used to add custom logic before assigning value to the property
    @JsonSetter("booksWritten")
    public void setNoOfBooks(Integer noOfBooks){
        this.booksWritten=noOfBooks!=null?noOfBooks:0;
    }

}
