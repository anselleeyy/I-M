package cn.ltysyn.infiniti.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InfinitiEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinitiEurekaApplication.class, args);
	}

}

