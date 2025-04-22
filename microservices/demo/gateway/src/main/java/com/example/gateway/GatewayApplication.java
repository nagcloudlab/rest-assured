package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Bean
	public ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new ServiceInstanceListSupplier() {
			@Override
			public String getServiceId() {
				return "service-a";
			}
			@Override
			public Flux<List<ServiceInstance>> get() {
				List<ServiceInstance> instance=List.of(
						new DefaultServiceInstance("instance1", "service-a", "localhost", 8081, false),
						new DefaultServiceInstance("instance2", "service-a", "localhost", 8082, false)
				);
				return Flux.just(instance);
			}
		};
	}

}
