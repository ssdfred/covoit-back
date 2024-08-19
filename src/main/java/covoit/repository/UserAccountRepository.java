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

	Iterable<UserAccount> findByEmailAndPassword(String name, String password);

	UserAccount findById(int id);
	UserAccount findByEmail(String email);

	List<UserAccount> findAll();

	void save(UserAccountDto userDB);

	UserAccount findByUserName(String username);

}
