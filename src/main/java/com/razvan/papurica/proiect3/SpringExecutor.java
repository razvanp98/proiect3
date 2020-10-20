package com.razvan.papurica.proiect3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringExecutor {

	public static void main(String[] args) {
		SpringApplication.run(SpringExecutor.class, args);
	}

}
