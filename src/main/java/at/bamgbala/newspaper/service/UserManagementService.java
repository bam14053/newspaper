/**
 * 
 */
package at.bamgbala.newspaper.service;

import java.util.List;

import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.domain.User;
import at.bamgbala.newspaper.jparepository.UserRepository;

/**
 * @author abideen
 *
 */
public class UserManagementService{
	private UserRepository userRepo;
	
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
	
	public User findUserByID(long id){
		return userRepo.findById(id);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
}
