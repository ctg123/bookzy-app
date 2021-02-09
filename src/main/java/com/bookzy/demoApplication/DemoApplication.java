package com.bookzy.demoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@ComponentScan("com.*") // This allows for the main application to scan all com packages included.
public class DemoApplication {

	@RequestMapping("/home")
	@ResponseBody
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
