package ozalp.restfulflower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.activation.DataSource;

@Configuration
public class SpringBeansConfig {

  @Bean
  public DataSource mysqlDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:5432/ecezalp");
    dataSource.setUsername("guest_user");
    dataSource.setPassword("guest_password");

    return (DataSource) dataSource;
  }

}
