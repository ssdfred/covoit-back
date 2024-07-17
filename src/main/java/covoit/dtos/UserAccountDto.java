package covoit.dtos;


/**
 * 
 */
/**
 * 
 */
/**
 * Data Transfer Object for User.
 */
public class UserAccountDto {

	private Long id;
	private String name;
	private String lastName;
	private boolean permis;
	private String password;
	/**
	 * 
	 */
	public UserAccountDto() {
		
	}
	@Override
	public String toString() {
		return "UserAccountDto [name=" + name + ", lastName=" + lastName + ", permis=" + permis + ", password="
				+ password + "]";
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
	 * 
	 * @return boolean
	 */
	public boolean isPermis() {
		return permis;
	}


	/**
	 * @param permis
	 */
	public void setPermis(boolean permis) {
		this.permis = permis;
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


}
