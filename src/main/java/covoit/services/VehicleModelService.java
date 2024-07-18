package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import covoit.entities.VehicleModel;
import covoit.repository.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	public List<VehicleModel> findAll() {
		return (List<VehicleModel>) vehicleModelRepository.findAll();
	}
	/**get the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return ServiceVehicle
	 */
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	/**Update the VehicleModel corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(VehicleModel object) {
		vehicleModelRepository.save(object);
		return "VehicleModel a été modifiée";
	}

	/**Create an VehicleModel 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public String create(VehicleModel object) {
		vehicleModelRepository.save(object);
		return "VehicleModel a été créée";
	}
	
	/**Delete the VehicleModel corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		vehicleModelRepository.deleteById(id);
		return "VehicleModel a été supprimée";
	}
}
