
package covoit.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covoit.dtos.UserAccountDto;
import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;

/**
 * Service interface for managing user accounts.
 */
@Service
public class UserAccountService {

	private static UserAccountRepository userAccountRepository;
	private PasswordEncoder passwordEncoder;



	/**
	 * Update the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public static boolean update(int id, UserAccount object) {
		UserAccountDto userDB;
	
			userDB = findById(id);
		
		if (userDB == null) {
			return false;
		}
		userDB.setName(object.getName());
		userDB.setLastName(object.getLastName());
		userAccountRepository.save(userDB);
		return true;
	}

	

	public static UserAccountDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create a Brand
	 * 
	 * @param Brand : the new Brand
	 * @return A confirmation message
	 */
	public static UserAccountDto toDto(UserAccount userAccount) {
		UserAccountDto dto = new UserAccountDto();
		dto.setName(userAccount.getName());
		dto.setPassword(userAccount.getPassword());

		return dto;
	}

	/**
	 * Delete the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public static boolean delete(int id) {
		Optional<UserAccount> userDB = userAccountRepository.findById(id);
		if (userDB == null) {
			return false;
		}
		userAccountRepository.deleteById(id);
		return true;
	}

	public void login(String name, String password) {
		Iterable<UserAccount> user = (userAccountRepository).findByEmailAndPassword(name, password);
		if (user != null && passwordEncoder.matches(name, password)) {

		} else {
			throw new RuntimeException("Email ou mot de passe incorrect");
		}
	}

}
