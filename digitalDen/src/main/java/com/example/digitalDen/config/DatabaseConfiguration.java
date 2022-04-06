package com.example.digitalDen.config;


import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.db.util.JPAAccess;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:application.properties")
@EnableWebMvc
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
public class DatabaseConfiguration {

    @Inject
    Environment env;

    @Bean
    public DataSource writeDataSource() throws PropertyVetoException{
        ComboPooledDataSource  dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(env.getRequiredProperty("jdbc.writedb.proxy.url"));
        dataSource.setUser(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        dataSource.setMaxIdleTime(120);
        dataSource.setMaxPoolSize(20);
        dataSource.setDebugUnreturnedConnectionStackTraces(true);
        return dataSource;
    }

    @Bean
    public JDBCAccess jdbcAccess() throws PropertyVetoException{
        JDBCAccess jdbcAccess = new JDBCAccess();
        jdbcAccess.setDataSource(writeDataSource());
        return jdbcAccess;
    }

    @Bean
    public JPAAccess jpaAccess(){return new JPAAccess();}


    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(writeDataSource());
        sessionFactory.setPackagesToScan("com");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
