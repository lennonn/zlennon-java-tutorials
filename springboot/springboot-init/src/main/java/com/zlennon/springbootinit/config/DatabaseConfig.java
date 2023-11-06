package com.zlennon.springbootinit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ConcurrentReferenceHashMap;

import javax.sql.DataSource;
import java.util.Map;


@Configuration
public class DatabaseConfig {
    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
