package com.osl.mvcapp.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*This implementations of WebApplicationInitializer will be detected automatically 
 * by SpringServletContainerInitializer,which itself is bootstrapped automatically 
 * by any Servlet 3.0 container.
 * SPI = Service Provider Interface
 * */
public class AppInitializer implements WebApplicationInitializer {

    /*Configure the given ServletContext with any servlets, filters, 
     * listeners context-params and attributes necessary for initializing 
     * this web application.
     * */
    public void onStartup(ServletContext container) throws ServletException {

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        rootContext.refresh();

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // To mitigate Cross-site Scripting (XSS), validate and escape the input data from user during processing on the server.
        container.setInitParameter("defaultHtmlEscape", "true");

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebMvcConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(mvcContext));
        dispatcher.setLoadOnStartup(1);
        /*Set<String> mappingConflicts = */
        dispatcher.addMapping("/");
    }

}