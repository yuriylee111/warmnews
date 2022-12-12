package com.lee.warmnews.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@ComponentScan("com.lee.warmnews")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@EnableAspectJAutoProxy
public class AppConfig {

    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/JSP/";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String PACKAGE_TO_SCAN_ENTITY = "com.lee.warmnews.entity";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String ORG_HIBERNATE_DIALECT_POSTGRESQL82DIALECT = "org.hibernate.dialect.PostgreSQL82Dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String TRUE_TEMPLATE = "true";

    private final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
        internalResourceViewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);

        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty(DRIVER)));
        dataSource.setUrl(environment.getProperty(URL));
        dataSource.setUsername(environment.getProperty(USERNAME));
        dataSource.setPassword(environment.getProperty(PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(PACKAGE_TO_SCAN_ENTITY);

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(HIBERNATE_DIALECT, ORG_HIBERNATE_DIALECT_POSTGRESQL82DIALECT);
        hibernateProperties.setProperty(HIBERNATE_SHOW_SQL, TRUE_TEMPLATE);

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        return localValidatorFactoryBean;
    }
}
