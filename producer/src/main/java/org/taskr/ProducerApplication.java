package org.taskr;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication {
	@Autowired
	CamelContext ctx;
	
	@PostConstruct
	private void init(){
		ctx.setTracing(true);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}
