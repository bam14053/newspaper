/**
 * 
 */
package at.bamgbala.newspaper.rest;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import at.bamgbala.newspaper.domain.DomainConfiguration;
import at.bamgbala.newspaper.repository.RepositoryConfiguration;

/**
 * @author abideen
 * 
 */
@Import(value = { DomainConfiguration.class, RepositoryConfiguration.class })
@Configuration
@ComponentScan(basePackageClasses = RestPackage.class)
public class RestApplicationConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}
}
