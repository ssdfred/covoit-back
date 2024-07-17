package covoit.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany
	@JoinTable(name="DRIVER_VEHICULE", joinColumns = { @JoinColumn(name = "id_driver") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_vehicle") } )
	private Set<Vehicle> vehicles = new HashSet<>();

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

	/** Getter pour bookings
	 * @return bookings
	 */
	public Set<Booking> getBookings() {
		return bookings;
	}

	/**Setter pour bookings
	 * @param bookings bookings 
	 */
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	/** Getter pour vehicles
	 * @return vehicles
	 */
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	/**Setter pour vehicles
	 * @param vehicles vehicles 
	 */
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
