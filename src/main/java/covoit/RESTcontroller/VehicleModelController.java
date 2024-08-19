package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.VehicleModelDto;
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
	public List<VehicleModelDto> findAll() {
		return service.findAll();
	}

	/**
	 * get the vehicle model corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The vehicle model
	 */
	@GetMapping("/{id}")
	public VehicleModelDto findById(@PathVariable int id) {
		return service.findById(id);
	}

	/**
	 * Update the vehicle model corresponding to the id given
	 * 
	 * @param id      : Id given
	 * @param address : modified vehicle model
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, VehicleModelDto vehicleModelDto) {
		service.update(id, vehicleModelDto);
	}

	/**
	 * Create a vehicle model
	 * 
	 * @param vehicle model : the new vehicle model
	 * @return A confirmation message
	 */
	@PostMapping
	public void create(VehicleModelDto vehicleModelDto) {
		service.create(vehicleModelDto);
	}

	/**
	 * Delete the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");

	}
}
