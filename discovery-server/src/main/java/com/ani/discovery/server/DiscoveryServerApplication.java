package com.ani.discovery.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableEurekaServer
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DiscoveryServerApplication {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Scheduled(fixedDelay=1000)
	@Async
	public void refreshRoutes(){
		//https://github.com/spring-cloud/spring-cloud-gateway/issues/1573
		//https://github.com/spring-cloud/spring-cloud-gateway/issues/1514
		publisher.publishEvent(new InstanceRegisteredEvent<Void>(this, null));
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}
}
