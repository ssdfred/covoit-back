package covoit.entities;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Represents a user account in the carpooling system.
 */
@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	private String email;
	private boolean driverLicence;
	private String password;
	
	/** Constructor
	 * @param name
	 * @param lastName
	 * @param driverLicence
	 * @param password
	 */
	public UserAccount(String name, String lastName, boolean driverLicence, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.driverLicence = driverLicence;
		this.password = password;
	}
	/**Constructor jpa
     * 
     */
	 @ElementCollection(fetch = FetchType.EAGER)
	    private List<GrantedAuthority> authorities;
	public UserAccount() {
		
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
    public boolean isDriverLicence() {
        return driverLicence;
    }
    public void setDriverLicence(boolean driverLicence) {
        this.driverLicence = driverLicence;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	 public UserDetails asUserDetails() {
	        return new User(name, password, authorities);
	    }
	

	

}