package covoit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import covoit.dtos.UserAccountDto;
import covoit.entities.UserAccount;

/**
 * 
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

	/**
	 * @param name
	 * @return String
	 */

	Optional<UserAccount> findByUserNameAndPassword(String userName, String password);
	UserAccount findByUserName(String userName);
	UserAccount findById(int id);
	UserAccount findByEmail(String email);
    
	List<UserAccount> findAll();

	void save(UserAccountDto userDB);

	

}
