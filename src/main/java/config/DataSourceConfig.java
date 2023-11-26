/*package config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.activation.DataSource;

@Configuration
@Slf4j
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.example.practise_Alisher"})
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2).
                    addScripts("src/main/resources/schema.sql", "src/main/resources/data.sql").build();
        } catch (Exception e) {
            log.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }*/

