package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.entities.VehicleModel;
import covoit.services.VehicleModelService;

/**
 * Define routes linked to VehicleModels
 * 
 */
@RestController
@RequestMapping("/models")
public class VehicleModelController {
	@Autowired
	private VehicleModelService service;

	/**
	 * Get all vehicle models
	 * 
	 */
	@GetMapping("/")
	public List<VehicleModel> getAddresses() {
		return service.getVehicleModels();
	}

	/**
	 * get the vehicle model corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The vehicle model
	 */
	@GetMapping("/{id}")
	public VehicleModel getVehicleModel(@PathVariable int id) {
		return service.getVehicleModel(id);
	}

	/**
	 * Update the vehicle model corresponding to the id given
	 * 
	 * @param id      : Id given
	 * @param address : modified vehicle model
	 */
	@PutMapping("/{id}")
	public void updateVehicleModel(@PathVariable int id, VehicleModel model) {
		service.updateVehicleModel(id, model);
	}

	/**
	 * Create a vehicle model
	 * 
	 * @param vehicle model : the new vehicle model
	 * @return A confirmation message
	 */
	@PostMapping
	public void createVehicleModel(VehicleModel model) {
		service.createVehicleModel(model);
	}

	/**
	 * Delete the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void deleteVehicleModel(int id) {
		service.deleteVehicleModel(id);
	}
}
