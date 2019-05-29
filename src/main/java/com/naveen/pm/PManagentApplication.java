package com.naveen.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
"com.naveen.pm.service", "com.naveen.pm.service.impl"})
@EnableAutoConfiguration
@EntityScan(basePackages="com.naveen.pm.model")
@ComponentScan(basePackages="com.naveen.pm.repository")
@EnableJpaRepositories("com.naveen.pm.repository")
@ComponentScan(basePackages="com.naveen.pm.api")
@ComponentScan(basePackages="com.naveen.pm.controller")
public class PManagentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PManagentApplication.class, args);
	}

}
