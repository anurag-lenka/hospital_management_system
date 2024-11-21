package com.tekpyramid.hms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MyConfig {
	
	@Bean
	HikariDataSource getDataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/experiment");
		hikariDataSource.setPassword("Alenka@123");
		hikariDataSource.setUsername("root");
		hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return hikariDataSource;
	}
}
