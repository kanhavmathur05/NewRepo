package com.springwithmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories({"com.springbootwithmongo.repository"})
public class SpringWithMongoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithMongoApplication.class, args);
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(SpringWithMongoApplication.class);
	}
}
