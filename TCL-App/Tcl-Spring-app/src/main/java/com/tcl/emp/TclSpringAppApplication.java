package com.tcl.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class TclSpringAppApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(TclSpringAppApplication.class, args);
	}

}
