package com.cfprac.domain;


import com.cfprac.config.CustomLocalDateTimeDeserializer;
import com.cfprac.config.CustomLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

//To define a parent/super class for an Entity
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //To use a custom serializer
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @CreationTimestamp
    public LocalDateTime createdDateTime;

    @UpdateTimestamp
    public LocalDateTime updatedDateTime;
}
