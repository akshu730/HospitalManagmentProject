package com.ty.hospital_management.hospital_app.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public OpenAPI swagger()
	{
		Server s = new Server();
		s.url("http://localhost:8080/hospital_app");
		s.description("Hello this is my hospital application you can go through");
		
		Contact c = new Contact();
		
		c.setName("Akshay");
		c.setEmail("akshayslathia728@gmail.com");
		c.setUrl("www.appolo.com");
		
		License l = new License();
		l.setName("MSI");
		l.setUrl("MSI-License");
		
		Info i = new Info();
		i.contact(c);
		i.description("Hello this is my hospital application you can go through");
		i.license(l);
		i.summary("Apollo hospital");
		i.version("1.0");
		
		return new OpenAPI().info(i).servers(List.of(s));
		
	}
}
