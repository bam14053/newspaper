/**
 * 
 */
package at.bamgbala.newspaper.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import at.bamgbala.newspaper.domain.DomainConfiguration;
import at.bamgbala.newspaper.repository.RepositoryConfiguration;
import at.bamgbala.newspaper.service.ServiceConfiguration;

/**
 * @author abideen
 *
 */
@Import(value = {DomainConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
@Configuration
@ComponentScan(basePackageClasses = RestPackage.class)
public class RestApplicationConfig {

}
