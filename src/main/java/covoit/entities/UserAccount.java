package covoit.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/**
 * Represents a user account in the carpooling system.
 */
@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	    private String name;
	    private String lastName;
	    private String email;
	    private String password;
	    private boolean permis;

	@ManyToMany
	@JoinTable(name ="useraccount_carpool", joinColumns = @JoinColumn(name = "id_userAccount"), inverseJoinColumns = @JoinColumn(name = "id_carpool"))

	private List<Carpool> carpools = new ArrayList<>();



	/**
	 * 
	 */
	public UserAccount() {

	}

	    public UserAccount(String name, String lastName, String email, String password, boolean permis) {
	        this.name = name;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	        this.permis = permis;
	    }

	/**
	 * Gets the unique identifier of the user.
	 * 
	 * @return the unique identifier of the user
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the user.
	 * 
	 * @param id the unique identifier of the user
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the first name of the user.
	 * 
	 * @return the first name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the first name of the user.
	 * 
	 * @param name the first name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the last name of the user.
	 * 
	 * @param lastName the last name of the user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the password of the user.
	 * 
	 * @return the password of the user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the password of the user.
	 * 
	 * @param password the password of the user
	 */
	public boolean isPermis() {
		return permis;
	}

	/**
	 * Sets the driving license status of the user.
	 * 
	 * @param permis true if the user has a driving license, false otherwise
	 */
	public void setPermis(boolean permis) {
		this.permis = permis;
	}

	/**
	 * Obtient le mot de passe de l'utilisateur.
	 * 
	 * @return le mot de passe de l'utilisateur
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Définit le mot de passe de l'utilisateur.
	 * 
	 * @param password le mot de passe de l'utilisateur
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return
	 */
	public List<Carpool> getCarpools() {
		return carpools;
	}

	/**
	 * @param carpools
	 */
	public void setCarpools(List<Carpool> carpools) {
		this.carpools = carpools;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

}
