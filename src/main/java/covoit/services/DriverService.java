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
	/**get the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	public Optional<Driver> findById(int id) {
		return driverRepository.findById(id);
	}

	/**Update the Brand corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Driver object) {
		driverRepository.save(object);
		return "Driver a été modifiée";
	}

	/**Create an Brand 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public String create(Driver object) {
		driverRepository.save(object);
		return "Driver a été créée";
	}
	
	/**Delete the Brand corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		driverRepository.deleteById(id);
		return "Driver a été supprimée";
	}
}
