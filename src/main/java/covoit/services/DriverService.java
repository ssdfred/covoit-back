package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Brand;
import covoit.entities.Driver;
import covoit.repository.DriverRepository;

@Service
public class DriverService {
	@Autowired
	private DriverRepository driverRepository;
	
	public List<Driver> findAll() {
		return (List<Driver>) driverRepository.findAll();
	}
	/**get the Driver corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Driver
	 */
	public Optional<Driver> findById(int id) {
		return driverRepository.findById(id);
	}

	/**Update the Driver corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Driver object) {
		driverRepository.save(object);
		return "Driver a été modifiée";
	}

	/**Create an Driver 
	 * @param Driver : the new Driver
	 * @return A confirmation message
	 */
	public String create(Driver object) {
		driverRepository.save(object);
		return "Driver a été créée";
	}
	
	/**Delete the Driver corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		driverRepository.deleteById(id);
		return "Driver a été supprimée";
	}
}
