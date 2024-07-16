package covoit.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**This class is for the drivers
 * 
 */
@Entity
@Table(name = "DRIVER")
public class Driver extends UserAccount{
	@OneToMany(mappedBy = "DRIVER")
	private Set<Booking> bookings = new HashSet<>();

	/** Constructor
	 * @param name
	 * @param lastName
	 * @param driverLicence
	 * @param password
	 * @param bookings
	 */
	public Driver(String name, String lastName, boolean driverLicence, String password) {
		super(name, lastName, driverLicence, password);
	}
	
	
	
	
}
