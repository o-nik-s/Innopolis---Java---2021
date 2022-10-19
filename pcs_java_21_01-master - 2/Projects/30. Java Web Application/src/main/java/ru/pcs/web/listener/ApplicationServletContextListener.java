package ru.pcs.web.listener;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    private HikariDataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        this.dataSource = context.getBean(HikariDataSource.class);
        //TODO: исправить
        servletContext.setAttribute("storagePath", "");
        servletContext.setAttribute("context", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dataSource.close();
    }
}
