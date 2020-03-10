package org.javaboy.jdbcs;

import org.javaboy.jdbcs.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootTest
class JdbcsApplicationTests {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Resource(name = "jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @Test
    void jdbcTemplateOne() {
        System.out.println(jdbcTemplateOne.query("select * from user", new BeanPropertyRowMapper<>(User.class)));
    }

    @Test
    void jdbcTemplateTwo() {
        System.out.println(jdbcTemplateTwo.query("select * from user", new BeanPropertyRowMapper<>(User.class)));
    }

}
