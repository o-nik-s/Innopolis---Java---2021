package ru.pcs.rmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import ru.pcs.rmi.services.UsersService;
import ru.pcs.rmi.services.UsersServiceImpl;

/**
 * 18.11.2021
 * RMI
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Configuration
public class RmiConfig {
    @Bean
    public RemoteExporter registerRMIExporter(UsersService usersService) {

        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("users-service");
        exporter.setServiceInterface(UsersService.class);
        exporter.setService(usersService);
        exporter.setRegistryPort(1099);
        return exporter;
    }
}
