package org.generation.SpringAssessment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("todoList");
        registry.addViewController("/view-to-do").setViewName("todoList");
        registry.addViewController("/add-to-do").setViewName("todoForm");

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //expose the images, js, css resources to the client(browser) so that they can access the necessary files to display
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }

}
