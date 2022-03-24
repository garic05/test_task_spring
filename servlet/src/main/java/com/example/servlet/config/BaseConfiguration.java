package com.example.servlet.config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class BaseConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.database-platform}")
    private String dialect;

    @Value("${spring.jpa.hibernate.ddl-auto}") private String ddl_auto;
    @Value("${spring.jpa.properties.hibernate.show_sql}") private  String show_sql;
    @Value("${spring.jpa.properties.hibernate.format_sql}") private String format_sql;
    @Value("${spring.jpa.properties.hibernate.cache.region.factory_class}") private String factory_class;
    @Value("${spring.jpa.properties.hibernate.cache.use_second_level_cache}") private String use_2nd_lvl_cache;
    @Value("${hibernate.packages_to_scan}") String packages_to_scan;





    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(packages_to_scan);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", dialect);

        properties.setProperty("hibernate.hbm2ddl.auto", ddl_auto);
        properties.setProperty("show_sql", show_sql);
        properties.setProperty("format_sql", format_sql);
        properties.setProperty("hibernate.cache.region.factory_class", factory_class);
        properties.setProperty("hibernate.cache.use_second_level_cache", use_2nd_lvl_cache);

        return properties;
    }


}
