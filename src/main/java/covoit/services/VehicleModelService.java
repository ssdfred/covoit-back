package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.VehicleModel;
import covoit.repository.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	public List<VehicleModel> getVehicleModels() {
		Iterable<VehicleModel> iterable = vehicleModelRepository.findAll();
		List<VehicleModel> models = new ArrayList<>();
		iterable.forEach(models::add);
		return models;
	}

	/**
	 * get the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return VehicleModel
	 */
	public VehicleModel getVehicleModel(int id) {
		return vehicleModelRepository.getById(id);
	}

	/**
	 * Update the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String updateVehicleModel(int id, VehicleModel object) {
		VehicleModel modelDB = getVehicleModel(id);
		modelDB.setName(object.getName());
		modelDB.setVehicles(object.getVehicles());
		vehicleModelRepository.save(modelDB);
		return "Le modèle a été modifié";
	}

	/**
	 * Create an VehicleModel
	 * 
	 * @param VehicleModel : the new VehicleModel
	 * @return A confirmation message
	 */
	public String createVehicleModel(VehicleModel object) {
		vehicleModelRepository.save(object);
		return "Le modèle a été créé";
	}

	/**
	 * Delete the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteVehicleModel(int id) {
		vehicleModelRepository.deleteById(id);
		return "Le modèle a été supprimé";
	}
}
