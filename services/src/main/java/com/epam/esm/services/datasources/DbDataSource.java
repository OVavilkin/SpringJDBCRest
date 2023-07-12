package com.epam.esm.services.datasources;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class DbDataSource {

  @Autowired Environment environment;

  private final String URL = "url";
  private final String USER = "dbuser";
  private final String DRIVER = "driver";
  private final String PASSWORD = "dbpassword";

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setUrl(environment.getProperty(URL));
    driverManagerDataSource.setUsername(environment.getProperty(USER));
    driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
    driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
    return driverManagerDataSource;
  }
}
