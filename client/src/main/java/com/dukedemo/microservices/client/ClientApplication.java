package com.dukedemo.microservices.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.AmazonInfo;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dukedemo.microservices.client"})
@EnableDiscoveryClient
@Configuration
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	
	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtilsProperties properties) {
		
		EurekaInstanceConfigBean bean = new EurekaInstanceConfigBean(new InetUtils(properties));
		AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		bean.setDataCenterInfo(info);
		return bean;
	}
}
