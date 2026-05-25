package com.mhp.config;

import com.mhp.interceptor.JwtTokenAdminInterceptor;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册JWT拦截器");
        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("/admin/**", "/user/**")
                .excludePathPatterns(
                    "/admin/auth/login",
                    "/admin/auth/logout",
                    "/user/auth/login",
                    "/user/auth/register",
                    "/user/auth/logout",
                    // Knife4j / SpringDoc 文档路径
                    "/doc.html",
                    "/v3/api-docs/**",
                    "/v3/api-docs",
                    "/webjars/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html"
                );
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    @Bean
    public OpenAPI openAPI() {
        log.info("准备生成Knife4j接口文档...");
        return new OpenAPI()
                .info(new Info()
                        .title("智慧校园心理健康服务平台管理端接口文档")
                        .version("2.0")
                        .description("智慧校园心理健康服务平台管理端接口文档")
                        .contact(new Contact()
                                .name("MHP Team")
                                .email("support@mhp.com")));
    }
}
