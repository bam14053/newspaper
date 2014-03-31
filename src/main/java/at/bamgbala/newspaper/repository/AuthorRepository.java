/**
 * 
 */
package at.bamgbala.newspaper.repository;

import org.springframework.data.repository.CrudRepository;

import at.bamgbala.newspaper.domain.Author;

/**
 * @author abideen
 * 
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
	Author findByFirstname(String name);
}
