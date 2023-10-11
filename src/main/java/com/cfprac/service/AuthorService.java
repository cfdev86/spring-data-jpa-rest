package com.cfprac.service;

import com.cfprac.domain.Author;
import com.cfprac.exception.RecordNotFoundException;
import com.cfprac.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findByName(String name) throws RecordNotFoundException {
        return authorRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException("Author not found."));
    }
}
