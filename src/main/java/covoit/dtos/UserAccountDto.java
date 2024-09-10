package covoit.dtos;

import java.util.List;

import covoit.entities.UserAccount;

/**
 * Data Transfer Object for User.
 */
public class UserAccountDto {

    private int id;
    private String userName;
    private String lastName;
    private String email;
    private boolean driverLicence;
    private String password;
    private List<CarpoolDto> carpools;
    private String role;  // Assurez-vous que le rôle est bien représenté comme une chaîne.

    public UserAccountDto toDto(UserAccount user) {
        UserAccountDto userDto = new UserAccountDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUserName(user.getUserName());
        userDto.setLastName(user.getLastName());
        userDto.setDriverLicence(user.isDriverLicence());
        // Ne pas exposer le mot de passe dans le DTO
        userDto.setRole(user.getAuthorities().stream()
                .map(auth -> auth.getAuthority())  // Convertit les autorités en chaînes
                .findFirst()  // Si plusieurs rôles sont possibles, choisissez la méthode appropriée
                .orElse(""));  // Définissez un rôle par défaut si aucun rôle n'est trouvé
        return userDto;
    }

    public UserAccount toBean(UserAccountDto userDto) {
        UserAccount user = new UserAccount();
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setLastName(userDto.getLastName());
        user.setDriverLicence(userDto.isDriverLicence());
        // Ne pas définir le mot de passe ici sans le hasher
        user.setPassword(userDto.getPassword()); // Assurez-vous que le mot de passe est haché avant de l'enregistrer
        // Assurez-vous que addAuthorities accepte une chaîne ou une liste d'autorités
        user.addAuthorities(userDto.getRole());
        return user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(boolean driverLicence) {
        this.driverLicence = driverLicence;
    }

    public List<CarpoolDto> getCarpools() {
        return carpools;
    }

    public void setCarpools(List<CarpoolDto> carpools) {
        this.carpools = carpools;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserAccountDto [id=" + id + ", userName=" + userName + ", lastName=" + lastName + ", email=" + email
                + ", driverLicence=" + driverLicence + ", password=" + password + ", carpools=" + carpools + ", role="
                + role + "]";
    }
}
