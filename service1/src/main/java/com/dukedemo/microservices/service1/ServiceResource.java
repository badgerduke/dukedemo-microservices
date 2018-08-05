package com.dukedemo.microservices.service1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceResource {

	//@Value("${service.instance.name}")
	//private String instance;

	@GetMapping("/")
	public String mesage() {
		return "Hello from service1";
	}
}
