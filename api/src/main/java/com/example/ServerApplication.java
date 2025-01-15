package com.example;

import com.example.api.bean.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(SecurityConfig.class)
//@ComponentScan(basePackages = {
//		"com.example.infra",
//		"com.example.api",
//		"com.example.common",
//		"com.example.domain",
//
//})
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
