package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.VehicleModel;
import covoit.repository.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	public List<VehicleModel> findAll() {
		return vehicleModelRepository.findAll();
	}

	/**
	 * get the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return VehicleModel
	 */
	public VehicleModel findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	/**
	 * Update the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, VehicleModel object) {
		VehicleModel modelDB = findById(id);
		if (modelDB == null) {
			return false;
		}
		modelDB.setName(object.getName());
		modelDB.setVehicles(object.getVehicles());
		vehicleModelRepository.save(modelDB);
		return true;
	}

	/**
	 * Create an VehicleModel
	 * 
	 * @param VehicleModel : the new VehicleModel
	 * @return A confirmation message
	 */
	public boolean create(VehicleModel object) {
		VehicleModel modelDB = vehicleModelRepository.findByName(object.getName());
		if (modelDB != null) {
			return false;
		}
		vehicleModelRepository.save(object);
		return true;
	}

	/**
	 * Delete the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		VehicleModel modelDB = findById(id);
		if (modelDB == null) {
			return false;
		}

		vehicleModelRepository.deleteById(id);
		return true;
	}
}
