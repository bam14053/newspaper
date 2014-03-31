/**
 * 
 */
package at.bamgbala.newspaper.service;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.util.Assert;

import at.bamgbala.newspaper.jparepository.RepositoryJpaConfiguration;
import at.bamgbala.newspaper.servicejpa.ServiceJpaConfiguration;
import at.bamgbala.newspaper.servicejpa.UserManagementService;

/**
 * @author abideen
 * 
 */
@Configuration
@Import(value = { RepositoryJpaConfiguration.class,
		ServiceJpaConfiguration.class })
public class UserTest {
	private UserManagementService userManagementService;
	AbstractApplicationContext context;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}

	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext(
				UserManagementService.class);
		userManagementService = context.getBean(UserManagementService.class);
	}

	@After
	public void teardown() {
		context.close();
	}

	@Test
	public void testService() {
		Assert.notNull(userManagementService);
		// logger.info("Persisting two users");
		// userManagementService.createNewUser("Abideen", "Bamgbala", "abi",
		// "hellO", "bam14053@hotmail.com", false);
		// userManagementService.createNewUser("Abideen", "Bamgbala", "abi",
		// "hellO", "bam14053@hotmail.com", true);
		// Assert.notEmpty(userManagementService.getAllUsers());
	}
}