package covoit.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import covoit.dtos.CarpoolDto;
import covoit.dtos.UserAccountDto;
import covoit.entities.Carpool;
import covoit.entities.UserAccount;
import covoit.entities.Vehicle;
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
    public void registerUser(UserAccountDto userDTO) {
        UserAccount user = convertToEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserAccountDto userDTO) {
        UserAccount user = userRepository.findById(userDTO.getId()).orElse(null);
        if (user != null) {
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setDriverLicence(userDTO.isDriverLicence());
            if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            userRepository.save(user);
        }
    }

    @Override
    public UserAccountDTO findById(Long id) {
        UserAccount user = userRepository.findById(id).orElse(null);
        return user != null ? convertToDto(user) : null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserAccountDto> findAllUsers() {
        return userRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    @Override
    public void logout(Long userId) {
        // Logique de déconnexion
    }
    @Override
    public void login(String name, String password) {
        Iterable<UserAccount> user = ( userRepository).findByEmailAndPassword(name, password); // A vérifier le problème
        if (user != null && passwordEncoder.matches(name, password)) {
            
        } else {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }
    }



    @Override
    public List<CarpoolDto> getCarpoolInfo(Long userId) {
        List<Carpool> carpools = carpoolRepository.findByUserAccounts_Id(userId);
        return carpools.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    private UserAccount convertToEntity(UserAccountDto userDTO) {
        UserAccount user = new UserAccount();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setDriverLicence(userDTO.isDriverLicence());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    private UserAccountDTO convertToDto(UserAccount user) {
        UserAccountDTO userDTO = new UserAccountDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDriverLicence(user.isDriverLicence());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    private CarpoolDTO convertToDto(Carpool carpool) {
        CarpoolDTO carpoolDTO = new CarpoolDTO();
        carpoolDTO.setId(carpool.getId());
        carpoolDTO.setAvailableSeat(carpool.getAvailableSeat());
        carpoolDTO.setStartDate(carpool.getStarDate());
//        carpoolDTO.setVehicle(convertToDto(carpool.getVehicle()));
//        carpoolDTO.setRoute(convertToDto(carpool.getRoute()));
        carpoolDTO.setUserAccounts(carpool.getUserAccounts().stream().map(this::convertToDto).collect(Collectors.toList()));
        return carpoolDTO;
    }

    private Vehicle convertToDto(Vehicle vehicle) {
        Vehicle vehicleDTO = new Vehicle();
        //vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setRegistration(vehicle.getRegistration());
        vehicleDTO.setNbSeat(vehicle.getNbSeat());
//        vehicleDTO.setBrand(convertToDto(vehicle.getBrand()));
//        vehicleDTO.setModel(convertToEntity(vehicle.getModel()));
//        vehicleDTO.setCategory(convertToDto(vehicle.getCategory()));
        return vehicleDTO;
    }






//    private VehicleDTO convertToDto(Vehicle vehicle) {
//        VehicleDTO vehicleDTO = new VehicleDTO();
//        vehicleDTO.setId(vehicle.getId());
//        vehicleDTO.setRegistration(vehicle.getRegistration());
//        vehicleDTO.setNbSeat(vehicle.getNbSeat());
//        vehicleDTO.setBrand(convertToDto(vehicle.getBrand()));
//        vehicleDTO.setModel(convertToDto(vehicle.getModel()));
//        vehicleDTO.setCategory(convertToDto(vehicle.getCategory()));
//        return vehicleDTO;
//    }

//    private RouteDTO convertToDto(Route route) {
//        RouteDTO routeDTO = new RouteDTO();
//        routeDTO.setId(route.getId());
//        routeDTO.setDuration(route.getDuration());
//        routeDTO.setKmTotal(route.getKmTotal());
//        routeDTO.setStartAddress(convertToDto(route.getStartAddress()));
//        routeDTO.setEndAddress(convertToDto(route.getEndAddress()));
//        return routeDTO;
//    }
//
//    private AddressDTO convertToDto(Address address) {
//        AddressDTO addressDTO = new AddressDTO();
//        addressDTO.setId(address.getId());
//        addressDTO.setStreet(address.getStreet());
//        addressDTO.setCity(address.getCity());
//        addressDTO.setZipCode(address.getZipCode());
//        addressDTO.setCountry(address.getCountry());
//        return addressDTO;
//    }
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