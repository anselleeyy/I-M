package cn.ltysyn.infiniti.center.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "cn.ltysyn.infiniti.common.model")
public class InfinitiUserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinitiUserCenterApplication.class, args);
	}

}

