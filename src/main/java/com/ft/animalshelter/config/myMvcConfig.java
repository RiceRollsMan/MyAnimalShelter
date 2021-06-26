package com.ft.animalshelter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//全面扩展springMVC
@Configuration
public class myMvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/ft").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/js/**","/css/**","/img/**",
                        "/user/login","/user/signup","/user/username_exist",
                        "/user/goSignUp",
                        "/user/toUser"
                );
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
//    }
}
