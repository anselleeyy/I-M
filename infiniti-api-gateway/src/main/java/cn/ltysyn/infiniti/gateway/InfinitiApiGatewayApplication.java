package cn.ltysyn.infiniti.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InfinitiApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinitiApiGatewayApplication.class, args);
	}

}

