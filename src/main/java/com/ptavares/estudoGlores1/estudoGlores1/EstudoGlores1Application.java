package com.ptavares.estudoGlores1.estudoGlores1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EstudoGlores1Application extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EstudoGlores1Application.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoGlores1Application.class, args);
	}

}
