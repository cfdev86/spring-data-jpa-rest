package com.cfprac.repository;

import com.cfprac.domain.Author;

import java.util.Optional;

public interface AuthorRepository extends ExtendedRepository<Author, Long>{
    Optional<Author> findByName(String name);
}
