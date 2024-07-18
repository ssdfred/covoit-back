package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Vehicle;
import covoit.entities.VehicleModel;
import covoit.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll() {
		return (List<Vehicle>) vehicleRepository.findAll();
	}
	/**get the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Vehicle
	 */
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	/**Update the Vehicle corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Vehicle object) {
		vehicleRepository.save(object);
		return "Vehicle a été modifiée";
	}

	/**Create an Vehicle 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public String create(Vehicle object) {
		vehicleRepository.save(object);
		return "Vehicle a été créée";
	}
	
	/**Delete the Vehicle corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		vehicleRepository.deleteById(id);
		return "Vehicle a été supprimée";
	}
}
