package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// Spring 구역: Vue와 MySQL 연결
@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost/vue_board?serverTimezone=UTC&useSSL=false");

        dataSource.setUsername("kb");
        dataSource.setPassword("Hyosung");

        return dataSource;
    }
}
