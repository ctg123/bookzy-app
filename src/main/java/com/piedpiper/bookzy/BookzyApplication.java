package com.piedpiper.bookzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.piedpiper"})
public class BookzyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookzyApplication.class, args);
	}

}
