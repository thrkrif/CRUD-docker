package com.myboard.board;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*") // 모든 출처 허용 (개발 시에만)
//                .allowedOrigins("http://localhost:3000", "http://react-frontend-container2") // React 앱 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
