package com.example.UserTrackservices;

import com.example.UserTrackservices.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserTrackservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTrackservicesApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/userTrackapp/user/track/*");
		return filterRegistrationBean;
	}

}
