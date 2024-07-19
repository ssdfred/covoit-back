package covoit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import covoit.entities.UserAccount;

/**
 * 
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	/**
	 * @param name
	 * @return String
	 */
	UserAccount findByName(String name);

	Iterable<UserAccount> findByEmailAndPassword(String email, String password);

	void registerUser(UserAccount userAccount);

	void updateUser(UserAccount userAccount);

	Optional<UserAccount> findById(Long id);

	void deleteUser(Long id);

	List<UserAccount> findAllUsers();

	UserAccount authenticateUser(String name, String password);

	void bookSV(Long userId);

	void deleteBookingSV(Long userId);

	void updateBookingSV(Long userId);

	void login(String name, String password);

	void logout(Long userId);

	void getCarpoolInfo(Long userId);

	void bookCarpool(Long userId);

	void deleteBookingCarpool(Long userId);

	void updateBookingCarpool(Long userId);

	UserAccount findById(int id);

	List<UserAccount> findAll();

}
