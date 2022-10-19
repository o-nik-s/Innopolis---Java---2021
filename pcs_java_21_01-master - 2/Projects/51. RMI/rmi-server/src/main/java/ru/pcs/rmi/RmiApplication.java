package ru.pcs.rmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.pcs.rmi.services.UsersService;

@SpringBootApplication
public class RmiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RmiApplication.class, args);
    }

}
