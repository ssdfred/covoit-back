package covoit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**This class is for the categories of vehicles
 * 
 */
@Entity
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String name;
	
	/** Constructor
	 * @param name
	 */
	public Category(String name) {
		super();
		this.name = name;
	}

	/** Constructor
	 * 
	 */
	public Category() {
		super();
	}

	/** Getter pour name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**Setter pour name
	 * @param name name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter pour id
	 * @return id
	 */
	public int getId() {
		return id;
	}
}
