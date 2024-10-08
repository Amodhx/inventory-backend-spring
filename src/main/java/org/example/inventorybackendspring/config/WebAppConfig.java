package org.example.inventorybackendspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "org.example.inventorybackendspring")
@EnableWebMvc
@EnableTransactionManagement
public class WebAppConfig  implements WebMvcConfigurer {

}
