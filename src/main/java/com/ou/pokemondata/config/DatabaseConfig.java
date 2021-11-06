 //Heroku
package com.ou.pokemondata.config;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DatabaseConfig {

 @Value("${spring.datasource.url}")
 private String dbUrl;

 @Bean
 public DataSource dataSource() {
     HikariConfig config = new HikariConfig();
     config.setJdbcUrl(dbUrl);
     return new HikariDataSource(config);
 }
}
