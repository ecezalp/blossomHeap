package ozalp.restfulflower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ozalp.restfulflower.repositories.FlowerRepository;

import javax.sql.DataSource;

@Configuration
public class SpringBeansConfig {

  @Bean
  public DataSource postgresqlDataSource() {
    DriverManagerDataSource driver = new DriverManagerDataSource();
    driver.setDriverClassName("org.postgresql.Driver");
    driver.setUrl("jdbc:postgresql://localhost:5432/ecezalp");
    driver.setUsername("ecezalp");
    driver.setPassword("");

    return driver;
  }

  @Bean
  FlowerRepository flowerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
    return new FlowerRepository(namedParameterJdbcTemplate);
  }

}
