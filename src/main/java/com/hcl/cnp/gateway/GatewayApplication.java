package com.hcl.cnp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GatewayApplication {

//	@Bean
//	DiscoveryClientRouteDefinitionLocator discoveryRoutes(DiscoveryClient dc, DiscoveryLocatorProperties dlp) {
//		return new DiscoveryClientRouteDefinitionLocator(dc, dlp);
//	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
