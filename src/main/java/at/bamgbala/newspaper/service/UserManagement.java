/**
 * 
 */
package at.bamgbala.newspaper.service;

import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.repository.PersistenceFactory;
import at.bamgbala.newspaper.repository.UserRepository;
//		Author a = new Author("Abideen", "Bamgbala", "abi", "hellO", "bam14053@hotmail.com");

/**
 * @author abideen
 *
 */
public class UserManagement {
	private UserRepository userRepo = new PersistenceFactory().userRepo();
	
	public void createNewUser(String firstname, String surname, String username, String password, String email, boolean author){		
		if(author){
			Author a = new Author(firstname, surname, username, password, email);
			userRepo.persist(a);
		}
		else{
			RegularUser ru = new RegularUser(firstname, surname, username, password, email);
			userRepo.persist(ru);
		}			
	}		
}
