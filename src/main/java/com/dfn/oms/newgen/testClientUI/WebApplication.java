package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.bean.User;
import com.dfn.oms.newgen.testClientUI.bean.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.stream.Stream;

@Configuration
//@EnableAutoConfiguration
//@ComponentScan("org.springframework.web.socket.config")

@SpringBootApplication
@EntityScan
public class WebApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("http://localhost:4200")
                        .allowedHeaders("*").allowCredentials(true);
            }
        };
    }
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("192.168.0.50" ).forEach(ip -> {
                User user = new User(ip,8181,10,100,10);
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

//    @Bean
//    CommandLineRunner init(ParameterRepository parameterRepository) {
//        return args -> {
//            Stream.of("1" ).forEach(unqReqId -> {
//                Order order = new Order(unqReqId , 45,"fdf");
//                parameterRepository.save(order);
//            });
//            parameterRepository.findAll().forEach(System.out::println);
//        };
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}

