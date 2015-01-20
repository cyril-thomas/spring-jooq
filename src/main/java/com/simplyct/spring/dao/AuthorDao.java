package com.simplyct.spring.dao;

import com.simplyct.spring.dao.dto.AuthorDTO;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.simplyct.spring.jooq.tables.Author.AUTHOR;
import static org.jooq.impl.DSL.lower;
import static org.jooq.impl.DSL.using;

/**
 * Created by cyril on 1/17/15.
 */
@Service
public class AuthorDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private DSLContext create;

    @PostConstruct
    protected void init() {
        create = using(jdbcTemplate.getDataSource(), SQLDialect.H2);
    }

    public List<AuthorDTO> getAuthors(){
        List<AuthorDTO> authors =
                create
                        .select()
                        .from(AUTHOR)
                        .fetch()
                        .into(AuthorDTO.class);
        return authors;
    }

    public AuthorDTO getAuthorByFirstName(String name){
        List<AuthorDTO> authorDTOs =
                create
                        .select()
                        .from(AUTHOR)
                        .where(AUTHOR.FIRST_NAME.lower().like(lower("%"+name+"%")))
                        .fetch()
                        .into(AuthorDTO.class);

        return authorDTOs.size() > 0 ? authorDTOs.get(0) : null;
    }

}
