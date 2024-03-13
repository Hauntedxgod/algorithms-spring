package ru.maxima;

import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AlgorithmsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmsSpringApplication.class, args);

    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
