package covoit.dtos;

import java.util.List;

import covoit.entities.UserAccount;

/**
 * Data Transfer Object for User.
 */
public class UserAccountDto {

	private int id;
	private String name;
	private String lastName;
	private String email;
	private boolean driverLicence;
	private String password;
	private List<CarpoolDto> carpools;

	
	public UserAccountDto toDto(UserAccount user) {
		UserAccountDto userDTO = new UserAccountDto();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setLastName(user.getLastName());
		userDTO.setDriverLicence(user.isDriverLicence());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}
	public UserAccount toBean(UserAccountDto userDTO) {
		UserAccount user = new UserAccount();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setLastName(userDTO.getLastName());
		user.setDriverLicence(userDTO.isDriverLicence());
		user.setPassword(userDTO.getPassword());
		return user;
	}

	/**
	 * Gets the unique identifier of the user.
	 * 
	 * @return the unique identifier of the user
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the user.
	 * 
	 * @param id the unique identifier of the user
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the user.
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the user.
	 * 
	 * @param name the username of the user
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the password of the user.
	 * 
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 * 
	 * @param password the password of the user
	 */
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
		return "UserAccountDto [name=" + name + ", lastName=" + lastName + ", driverLicence=" + driverLicence
				+ ", carpools=" + carpools + "]";
	}

}
