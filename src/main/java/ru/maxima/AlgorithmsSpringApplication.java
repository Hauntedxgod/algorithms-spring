package ru.maxima;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AlgorithmsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmsSpringApplication.class, args);
//        ApplicationContext context = new ClassPathXmlApplicationContext("bank.xml");
    }

}
