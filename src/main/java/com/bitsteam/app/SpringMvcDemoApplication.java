package com.bitsteam.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:configuration.properties", encoding = "UTF-8")
public class SpringMvcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDemoApplication.class, args);
	}

}
