package covoit.services;


import covoit.entities.UserAccount;

import java.util.List;

/**
 * Service interface for managing user accounts.
 */
public interface UserAccountService {

    /**
     * Registers a new user account.
     * 
     * @param userAccountDTO the user data transfer object
     */
    void registerUser(UserAccount userAccount);

    /**
     * Updates an existing user account.
     * 
     * @param userDTO the user data transfer object
     */
    void updateUser(UserAccount userAccount);

    /**s
     * Finds a user by their unique identifier.
     * 
     * @param id the unique identifier of the user
     * @return the user data transfer object
     */
    UserAccount findById(Long id);

    /**
     * Deletes a user by their unique identifier.
     * 
     * @param id the unique identifier of the user
     */
    void deleteUser(Long id);

    /**
     * Finds all users.
     * 
     * @return a list of user data transfer objects
     */
    List<UserAccount> findAllUsers();
    
    /**
     * Authenticates a user with the provided credentials.
     * 
     * @param name the username of the user
     * @param password the password of the user
     * @return the authenticated user data transfer object
     */
    UserAccount authenticateUser(String name, String password);
}
