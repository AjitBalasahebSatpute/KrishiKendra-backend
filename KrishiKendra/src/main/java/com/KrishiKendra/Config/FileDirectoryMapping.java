package com.KrishiKendra.Config;

	
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileDirectoryMapping implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map URL path to the directory
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:/Users/abc/Documents/krishikendra/uploads/");
    }
}


