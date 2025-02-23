package ru.online.t1_academy.projectT1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProjectT1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectT1Application.class);
    }
}
