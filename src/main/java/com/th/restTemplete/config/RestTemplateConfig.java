package com.th.restTemplete.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@Setter
@Configuration
@ConfigurationProperties(prefix = "rest-service")
public class RestTemplateConfig {

	private String host;
	
	@Bean
	RestTemplate ServiceRestTemplate(RestTemplateBuilder builder) {
		return builder.uriTemplateHandler(new RootUriTemplateHandler(host)).build();
	}
}
