package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    private static final Logger log =
            LoggerFactory.getLogger(MemberRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void signup(Member member) throws Exception {
        log.info("signup()");

        String query = "insert into member(userId, password) " +
                "values(?, ?)";

        jdbcTemplate.update(query, member.getUserId(),
                member.getPassword());
    }
}
