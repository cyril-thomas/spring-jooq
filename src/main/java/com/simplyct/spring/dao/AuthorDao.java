package com.simplyct.spring.dao;

import com.simplyct.spring.jooq.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.simplyct.spring.jooq.tables.Author.AUTHOR;
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

    public List<AuthorRecord> getAuthors(){
        List<AuthorRecord> authors =
                create
                        .select()
                        .from(AUTHOR)
                        .fetch()
                        .into(AuthorRecord.class);

        return authors;

    }

}
