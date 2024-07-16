package covoit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;

@Service
public class UserAccountService {
@Autowired
private UserAccountRepository userAccountRepository;

@Autowired
private PasswordEncoder passwordEncoder;

public void save(UserAccount user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userAccountRepository.save(user);
}
}
