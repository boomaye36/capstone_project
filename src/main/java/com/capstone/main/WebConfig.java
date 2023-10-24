package com.capstone.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
    public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**")
        .allowedOrigins("http://ec2-3-34-136-247.ap-northeast-2.compute.amazonaws.com:3000") // 허용할 출처를 지정
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true)
        .maxAge(3600);
    }

}
