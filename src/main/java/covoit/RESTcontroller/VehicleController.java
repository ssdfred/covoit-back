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

import covoit.entities.Vehicle;
import covoit.services.VehicleService;

/**
 * Define routes linked to Addresses
 * 
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService service;

	/**
	 * Get all vehicles
	 * 
	 */
	@GetMapping("/")
	public List<Vehicle> getVehicles() {
		return service.getVehicles();
	}

	/**
	 * get the vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The vehicle
	 */
	@GetMapping("/{id}")
	public Vehicle getVehicle(@PathVariable int id) {
		return service.getVehicle(id);
	}
	

	/**Update the vehicle corresponding to the id given
	 * @param id : Id given
	 * @param vehicle : modified vehicle
	 */
	@PutMapping("/{id}")
	public void updateVehicle(@PathVariable int id, Vehicle vehicle) {
		service.updateVehicle(id,vehicle);
	}
	
	/**Create a vehicle 
	 * @param vehicle : the new vehicle
	 */
	@PostMapping
	public void createVehicle(Vehicle vehicle) {
		service.createVehicle(vehicle);
	}
	
	/**Delete the vehicle corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void deleteVehicle(int id) {
		service.deleteVehicle(id);
	}
}
