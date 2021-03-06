package com.simplyct.spring.service;

import com.simplyct.spring.dao.AuthorDao;
import com.simplyct.spring.dao.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyril on 1/17/15.
 */
@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;

    public List<AuthorDTO> getAllAuthors(){
       return authorDao.getAuthors();
    }

    public AuthorDTO getAuthorByFirstName(String name){
        return authorDao.getAuthorByFirstName(name);
    }
 }
