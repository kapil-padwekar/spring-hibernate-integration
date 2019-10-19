package com.osl.mvcapp.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * This class is used as the replacement of dispatcher-config.xml.
 * Sample example of dispatcher-config.xml is as follows.
 * <pre class="code">
 * {@code
 * <beans xmlns="http://www.springframework.org/schema/beans"
 *		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *		xsi:schemaLocation="http://www.springframework.org/schema/beans
 *		http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
 *	
 *	    <bean name="/welcome.htm"
 *			class="package.name.ClassNameController" />
 *	
 *	    <bean id="viewResolver"
 *	    	class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
 *	        <property name="prefix">
 *	            <value>/WEB-INF/pages/</value>
 *	        </property>
 *	        <property name="suffix">
 *	            <value>.jsp</value>
 *	        </property>
 *	    </bean>
 *	
 *	</beans>}</pre>
 * 
 * @author Kapsi
 *
 */
@Configuration
@Import(HibernateConfiguration.class)
@ComponentScan(basePackages = { "com.osl.mvcapp.service", "com.osl.mvcapp.dao", "com.osl.mvcapp.util" })
public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}