package com.example.demoapp;

import helloautoconfig.ConsoleHelloService;
import helloautoconfig.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	private HelloService helloService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		helloService.sayHello("World");
	}

//	@Bean
//	HelloService console(){
//		return new ConsoleHelloService();
//	}
}
