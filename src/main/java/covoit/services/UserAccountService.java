import java.util.List;

import covoit.dtos.CarpoolDto;

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