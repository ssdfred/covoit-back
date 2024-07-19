import covoit.dtos.CarpoolDto;
import covoit.entities.ServiceVehicle;
import covoit.entities.UserAccount;
import covoit.repository.UserAccountRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Service interface for managing user accounts.
 */
public interface UserAccountService {
    List<CarpoolDto> getCarpoolInfo(Long userId);
    void bookCarpool(Long carpoolId, Long userId);
    void deleteBookingCarpool(Long carpoolId, Long userId);
    void updateBookingCarpool(Long carpoolId, CarpoolDto carpoolDTO);
    void logout(Long id);
    void login(String email, String password);
}