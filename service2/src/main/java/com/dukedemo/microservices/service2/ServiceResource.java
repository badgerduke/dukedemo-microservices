package com.dukedemo.microservices.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceResource {

	@GetMapping("/")
	public String mesage() {
		return "Hello from service2";
	}
}
