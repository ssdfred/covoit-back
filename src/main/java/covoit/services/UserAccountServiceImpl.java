package covoit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of UserAccountService for managing user accounts.
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerUser(UserAccount userAccount) {
        UserAccount user = new UserAccount();
        user.setName(userAccount.getName());
        user.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(UserAccount userAccount) {
        UserAccount user = userRepository.findById(userAccount.getId()).orElse(null);
        if (user != null) {
            user.setName(userAccount.getName());
            if (userAccount.getPassword() != null && !userAccount.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userAccount.getPassword()));
            }
            userRepository.save(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserAccount findById(Long id) {
        UserAccount user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setId(user.getId());
        userAccount.setName(user.getName());
        // Do not return password in DTO
        return userAccount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserAccount> findAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserAccount userAccount = new UserAccount();
            userAccount.setId(user.getId());
            userAccount.setName(user.getName());
            return userAccount;
        }).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserAccount authenticateUser(String username, String password) {
        UserAccount user = userRepository.findByName(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            UserAccount userAccount = new UserAccount();
            userAccount.setId(user.getId());
            userAccount.setName(user.getName());
            return userAccount;
        }
        return null;
    }


}
