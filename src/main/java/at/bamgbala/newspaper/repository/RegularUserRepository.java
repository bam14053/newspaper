/**
 * 
 */
package at.bamgbala.newspaper.repository;
import org.springframework.data.repository.CrudRepository;
import at.bamgbala.newspaper.domain.RegularUser;

/**
 * @author abideen
 * 
 */
public interface RegularUserRepository extends CrudRepository<RegularUser, Long>{
	
}
