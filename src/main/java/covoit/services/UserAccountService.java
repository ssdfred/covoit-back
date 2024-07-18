package covoit.services;

import java.util.List;

import covoit.dtos.CarpoolDTO;
import covoit.dtos.UserAccountDTO;


public interface UserAccountService {

    void registerUser(UserAccountDTO userDTO);
    void updateUser(UserAccountDTO userDTO);
    UserAccountDTO findById(Long id);
    void deleteUser(Long id);
    List<UserAccountDTO> findAllUsers();
    void login(String name, String password);
    void logout(Long userId);
    List<CarpoolDTO> getCarpoolInfo(Long userId);
    void bookCarpool(Long carpoolId, Long userId);
    void deleteBookingCarpool(Long carpoolId, Long userId);
}
