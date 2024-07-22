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
	UserAccount findByName(String name);

	Iterable<UserAccount> findByEmailAndPassword(String email, String password);

	Optional<UserAccount> findById(int id);

	List<UserAccount> findAllUsers();

	UserAccount authenticateUser(String name, String password);

	List<UserAccount> findAll();

	void save(UserAccountDto userDB);

}
