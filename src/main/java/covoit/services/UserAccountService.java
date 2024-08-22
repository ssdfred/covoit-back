
package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covoit.dtos.UserAccountDto;
import covoit.entities.UserAccount;
import covoit.exception.AnomalieException;
import covoit.repository.UserAccountRepository;

/**
 * Service interface for managing user accounts.
 */
@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository repository;
	private PasswordEncoder passwordEncoder;


	public List<UserAccountDto> findAll() {
		List<UserAccount> users = new ArrayList<>();
		if(repository.findAll() != null) {
			users = repository.findAll();
		}else {
			System.out.println("Rien trouver");
		}
		List<UserAccountDto> usersDto = new ArrayList<>();
		for (UserAccount item : users) {
			usersDto.add(new UserAccountDto().toDto(item));
		}
		return usersDto;
	}

	public UserAccountDto findById(int id) {
		UserAccount userAccount = repository.findById(id);
		if (userAccount == null) {
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

	  public void create(UserAccount userAccount) {
	        // Logique pour créer un utilisateur
	        if (repository.findByUserName(userAccount.getUserName()) != null) {
	            throw new RuntimeException("User already exists");
	        }
	        userAccount.setPassword(new BCryptPasswordEncoder().encode(userAccount.getPassword()));
	        repository.save(userAccount);
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

	public UserAccountService(UserAccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAccount login(String username, String rawPassword) throws AnomalieException {
        // Rechercher l'utilisateur
        UserAccount user = repository.findByUserName(username);
        
        // Vérifier si l'utilisateur existe
        if (user == null) {
            throw new AnomalieException("Nom d'utilisateur ou mot de passe incorrect");
        }

        // Vérifier le mot de passe
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user; // Authentification réussie
        } else {
            throw new AnomalieException("Nom d'utilisateur ou mot de passe incorrect");
        }
    }
    }


