package com.springboot.blogapp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "SpringBoot Blog App Rest Api's",
				description = "SpringBoot Blog App Rest Api's Documentation",
				version = "v1.0",
				contact = @Contact(
						name="Taniya",
						email = "taniyapushey@gmail.com",
						url = ""
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/Taniya1493/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SpringBoot Blog Api documentation",
				url = "https://github.com/Taniya1493/springboot-blog-application"
		)
)
public class SpringbootBlogAppApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogAppApplication.class, args);
	}

}
