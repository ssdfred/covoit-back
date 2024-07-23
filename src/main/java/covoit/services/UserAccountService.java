
package covoit.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covoit.dtos.AddressDto;
import covoit.dtos.UserAccountDto;
import covoit.entities.Address;
import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;

/**
 * Service interface for managing user accounts.
 */
@Service
public class UserAccountService {

	private static UserAccountRepository repository;
	private PasswordEncoder passwordEncoder;
	
	public UserAccountDto findById(int id) {
		UserAccount userAccount = repository.findById(id);
		if(userAccount == null) {
			return null;
		}
		return new UserAccountDto().toDto(userAccount);
	}
	/**
	 * Update the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, UserAccountDto object) {
		UserAccount userDB = repository.findById(id);
		
		if (userDB == null) {
			return false;
		}
		userDB = object.toBean(object);
		repository.save(userDB);
		return true;
	}

	public boolean create(UserAccountDto userAccountDto) {
		UserAccount userAccount = repository.findByEmail(userAccountDto.getEmail());
		if (userAccount == null) {
			repository.save(userAccountDto.toBean(userAccountDto));
			return true;
		}
		return false;
	}
	/**
	 * Delete the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		UserAccount userDB = repository.findById(id);
		if (userDB == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}

	public void login(String email, String password) {
		Iterable<UserAccount> user = repository.findByEmailAndPassword(email, password);
		if (user != null && passwordEncoder.matches(email, password)) {

		} else {
			throw new RuntimeException("Email ou mot de passe incorrect");
		}
	}

}
