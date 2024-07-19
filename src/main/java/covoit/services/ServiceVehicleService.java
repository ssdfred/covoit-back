package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.ServiceVehicle;
import covoit.repository.ServiceVehicleRepository;

@Service
public class ServiceVehicleService {
	@Autowired
	private ServiceVehicleRepository serviceVehicleRepository;
	
	public List<ServiceVehicle> findAll() {
		return (List<ServiceVehicle>) serviceVehicleRepository.findAll();
	}
	/**get the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return ServiceVehicle
	 */
	public Optional<ServiceVehicle> findById(int id) {
		return serviceVehicleRepository.findById(id);
	}

	/**Update the ServiceVehicle corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(ServiceVehicle object) {
		serviceVehicleRepository.save(object);
		return "ServiceVehicle a été modifiée";
	}

	/**Create an ServiceVehicle 
	 * @param ServiceVehicle : the new ServiceVehicle
	 * @return A confirmation message
	 */
	public String create(ServiceVehicle object) {
		serviceVehicleRepository.save(object);
		return "ServiceVehicle a été créée";
	}
	
	/**Delete the ServiceVehicle corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		serviceVehicleRepository.deleteById(id);
		return "ServiceVehicle a été supprimée";
	}
}
