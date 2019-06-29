package com.persteenolsen.springbootjsfprimefacesjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.*;


@SpringBootApplication
//public class SpringBootJsfPrimefacesJpaApplication {
	public class SpringBootJsfPrimefacesJpaApplication extends SpringBootServletInitializer {

	// Ready for builing a war file used for Tomcat
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootJsfPrimefacesJpaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsfPrimefacesJpaApplication.class, args);
	}

}
