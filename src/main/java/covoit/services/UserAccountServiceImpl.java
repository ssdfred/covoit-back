package covoit.services;


import covoit.dtos.CarpoolDTO;
import covoit.dtos.UserAccountDTO;
import covoit.entities.Carpool;
import covoit.entities.UserAccount;
import covoit.entities.Vehicle;
import covoit.repository.CarpoolRepositorry;
import covoit.repository.UserAccountRepository;
import covoit.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    @Autowired
    private CarpoolRepositorry carpoolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void registerUser(UserAccountDTO userDTO) {
        UserAccount user = convertToEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserAccountDTO userDTO) {
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
    public List<UserAccountDTO> findAllUsers() {
        return userRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void login(String name, String password) {
        UserAccount user = userRepository.findByName(name);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Logique de connexion
        } else {
            throw new RuntimeException("Nom ou mot de passe incorrect");
        }
    }

    @Override
    public void logout(Long userId) {
        // Logique de déconnexion
    }

    @Override
    public List<CarpoolDTO> getCarpoolInfo(Long userId) {
        List<Carpool> carpools = carpoolRepository.findByUserAccounts_Id(userId);
        return carpools.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void bookCarpool(Long carpoolId, Long userId) {

    }

    @Override
    public void deleteBookingCarpool(Long carpoolId, Long userId) {

    }

    private UserAccount convertToEntity(UserAccountDTO userDTO) {
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
}