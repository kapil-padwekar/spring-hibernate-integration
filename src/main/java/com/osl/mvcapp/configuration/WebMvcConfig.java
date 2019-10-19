package com.osl.mvcapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.kapsi.mvcapp.controller" })
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // equivalents for <mvc:resources/> tags
        registry.addResourceHandler("/resources/**").addResourceLocations("WEB-INF/resources/html/");

        registry.addResourceHandler("/resources/css/**").addResourceLocations("WEB-INF/resources/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/resources/img/**").addResourceLocations("WEB-INF/resources/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/resources/js/**").addResourceLocations("WEB-INF/resources/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/resources/app/**").addResourceLocations("WEB-INF/resources/app/").setCachePeriod(31556926);
    }

    // equivalent for <mvc:default-servlet-handler/> tag
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
