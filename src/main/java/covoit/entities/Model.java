package covoit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**This class is for the models of vehicles
 * 
 */
@Entity
@Table(name = "MODEL")
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String name;
	
	/** Constructor
	 * @param name
	 */
	public Model(String name) {
		this.name = name;
	}

	/** Constructor jpa
	 * 
	 */
	public Model() {
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
