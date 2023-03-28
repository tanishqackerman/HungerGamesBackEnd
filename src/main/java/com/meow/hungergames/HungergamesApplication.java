package com.meow.hungergames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HungergamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HungergamesApplication.class, args);
	}

}