package com.architecturelab.repair.application;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.architecturelab.repair.application.config.correlation.CorrelationIdInterceptor;

@SpringBootApplication(scanBasePackages = "com.architecturelab.repair")
public class RepairRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairRestApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate() {
            {
                setInterceptors(Collections.singletonList(new CorrelationIdInterceptor()));
            }
        };
    }
}
