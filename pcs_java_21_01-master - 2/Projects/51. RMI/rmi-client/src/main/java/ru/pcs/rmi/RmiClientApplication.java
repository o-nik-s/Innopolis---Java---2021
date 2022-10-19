package ru.pcs.rmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ru.pcs.rmi.services.UsersService;

@SpringBootApplication
public class RmiClientApplication {

    @Bean
    RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        bean.setServiceInterface(UsersService.class);
        bean.setServiceUrl("rmi://localhost:1099/users-service");

        return bean;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RmiClientApplication.class, args);
        UsersService usersService = context.getBean(UsersService.class);
        System.out.println(usersService.getUsersLimit(2));
    }

}
