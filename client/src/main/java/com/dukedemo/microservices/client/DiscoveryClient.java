package com.dukedemo.microservices.client;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@Component
public class DiscoveryClient {
	
	public void callDiscovery() {
		
		WebClient client = WebClient.create("http://localhost:8080");
		ResponseSpec response = client
				.method(HttpMethod.GET)
				.uri("/resource")
				.retrieve();
		
		response.bodyToMono(String.class).single().doOnSuccess((s) -> System.out.println(s));
	}
	
	
}

