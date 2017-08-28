package com.manish.javadev.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Swagger 2 is enabled through the @EnableSwagger2 annotation.
 * 
 * After the Docket bean is defined, its select() method returns an instance of
 * ApiSelectorBuilder, which provides a way to control the endpoints exposed by
 * Swagger.
 * 
 * Predicates for selection of RequestHandlers can be configured with the help
 * of RequestHandlerSelectors and PathSelectors. Using any() for both will make
 * documentation for your entire API available through Swagger.
 * 
 * This configuration is enough to integrate Swagger 2 into existing Spring Boot
 * project. For other Spring projects, some additional tuning is required.
 * 
 * 
 * @author Manish
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.manish.javadev.controller")).paths(PathSelectors.any())
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Online Bank", "1.0",
				"Terms of service",
				new Contact("M.D Srivastava", "http://manishjavadev.com/home.html", "m.d.srivastava"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}