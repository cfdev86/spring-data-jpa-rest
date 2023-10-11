package com.cfprac.controller;

import com.cfprac.domain.Author;
import com.cfprac.exception.RecordNotFoundException;
import com.cfprac.service.AuthorService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/findByName")
    public Author findByName(@Param("name") String name) throws RecordNotFoundException {
        return authorService.findByName(name);
    }

}
