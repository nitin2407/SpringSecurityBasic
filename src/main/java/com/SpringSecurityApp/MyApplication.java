package com.SpringSecurityApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.SpringSecurityApp.repository")
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages={"com.myApp.controllers","com.myApp.services","com.myApp.repository","com.myApp.model"})
@ComponentScan
public class MyApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}