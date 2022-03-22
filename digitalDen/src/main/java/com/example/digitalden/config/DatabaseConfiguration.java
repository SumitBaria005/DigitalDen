package com.example.digitalden.config;


import com.example.digitalden.db.util.JDBCAccess;
import com.example.digitalden.db.util.JPAAccess;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:application.properties")
@EnableWebMvc
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

}
