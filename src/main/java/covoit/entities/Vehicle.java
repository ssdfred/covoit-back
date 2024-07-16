package covoit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**This class is for the vehicles
 * 
 */
@Entity
@Table(name = "VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String registration;
	protected int nbSeat;
	@ManyToOne
	@JoinColumn(name = "ID_BRAND")
	protected Brand brand;
	@ManyToOne
	@JoinColumn(name = "ID_MODEL")
	protected Model model;
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORY")
	protected Category category;
	
	/** Constructor
	 * @param registration
	 * @param nbSeat
	 * @param brand
	 * @param model
	 * @param category
	 */
	public Vehicle(String registration, int nbSeat, Brand brand, Model model, Category category) {
		this.registration = registration;
		this.nbSeat = nbSeat;
		this.brand = brand;
		this.model = model;
		this.category = category;
	}

	/** Constructor jpa
	 * 
	 */
	public Vehicle() {
	}

	/** Getter pour registration
	 * @return registration
	 */
	public String getRegistration() {
		return registration;
	}

	/**Setter pour registration
	 * @param registration registration 
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	/** Getter pour nbSeat
	 * @return nbSeat
	 */
	public int getNbSeat() {
		return nbSeat;
	}

	/**Setter pour nbSeat
	 * @param nbSeat nbSeat 
	 */
	public void setNbSeat(int nbSeat) {
		this.nbSeat = nbSeat;
	}

	/** Getter pour brand
	 * @return brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**Setter pour brand
	 * @param brand brand 
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/** Getter pour model
	 * @return model
	 */
	public Model getModel() {
		return model;
	}

	/**Setter pour model
	 * @param model model 
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/** Getter pour category
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**Setter pour category
	 * @param category category 
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/** Getter pour id
	 * @return id
	 */
	public int getId() {
		return id;
	}
}
