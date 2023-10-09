package com.cfprac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;

//@NoRepositoryBean will ensure Spring doesn't create a bean for ExtendedRepository
//By default, Spring behaviour is to create an implementation for all subinterfaces of Repository
//All common standard methods can be defined in this interface
@NoRepositoryBean
public interface ExtendedRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
