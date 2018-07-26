package com.hcl.cnp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;


@SpringBootApplication
public class GatewayApplication {

//	@Bean
//	RouterFunction<?> routes() {
//		return
//				route(GET("/delay"), r -> ok().body(Flux.just("Hello HCL!").delayElements(Duration.ofSeconds(10)), String.class));
//	}

	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("delay", r -> r.path("/patient-service/delay")
						.uri("http://localhost:8080/delay"))
				.route("findAll", r -> r.path("/patient-service/find-all")
						.uri("http://localhost:8080/find-all"))
//				.route("findById", r -> r.path("/patient-service/patient/**")
//						.filters(f -> f.filter((exchange, filterChain) -> {
//							String id = exchange.getRequest().getQueryParams().getFirst("id");
//							ServerHttpRequest request = exchange.getRequest().mutate()
//									.path("/patient-service/patient/"+id)
//									.build();
//							return filterChain.filter(exchange.mutate().request(request).build());
//						}))
//						.uri("http://localhost:8080/patient"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
