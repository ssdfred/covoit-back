package covoit.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covoit.dtos.CarpoolDTO;
import covoit.entities.Carpool;
import covoit.entities.UserAccount;
import covoit.repository.CarpoolRepository;
import covoit.repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    @Autowired
    private CarpoolRepository carpoolRepository;

//    @Autowired
//    private VehicleServiceReservationRepository vehicleServiceReservationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void login(String name, String password) {
        Iterable<UserAccount> user = ( userRepository).findByEmailAndPassword(name, password); // A vérifier le problème
        if (user != null && passwordEncoder.matches(name, password)) {
            
        } else {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }
    }



    @Override
    public List<CarpoolDTO> getCarpoolInfo(Long userId) {
        List<Carpool> carpools = carpoolRepository.findByUserAccounts_Id(userId);
        return null;
    }

   

    @Override
    public void deleteBookingCarpool(Long carpoolId, Long userId) {
        Carpool carpool = carpoolRepository.findById(carpoolId).orElseThrow(() -> new RuntimeException("Covoiturage non trouvé"));
        UserAccount user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        carpool.getUserAccounts().remove(user);
        carpoolRepository.save(carpool);
    }

    @Override
    public void updateBookingCarpool(Long carpoolId, CarpoolDTO carpoolDTO) {
        // Mise à jour des informations de covoiturage
    }



    @Override
    public void bookCarpool(Long carpoolId, Long userId) {
	// TODO Auto-generated method stub
	
    }



    @Override
    public void logout(Long id) {
	// TODO Auto-generated method stub
	
    }


}