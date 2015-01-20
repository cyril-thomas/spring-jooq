package com.simplyct.spring.controller;

import com.simplyct.spring.dao.dto.AuthorDTO;
import com.simplyct.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cyril on 1/17/15.
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("/all")
    public List getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @RequestMapping("/firstName")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {

        if (name == null || name.isEmpty()) {
            return "Hello!";
        } else {
            AuthorDTO authorDTO = authorService.getAuthorByFirstName(name);
            return authorDTO != null?
                    String.format("Hello %s! Your id is :%s", authorDTO.getFirstName()+" "+authorDTO.getLastName(), authorDTO.getId())
                    : "Sorry not found";
        }
    }
}
