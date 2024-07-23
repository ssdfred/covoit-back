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

import covoit.dtos.VehicleDto;
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
	public List<VehicleDto> findAll() {
		return service.findAll();
	}

	/**
	 * get the vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The vehicle
	 */
	@GetMapping("/{id}")
	public VehicleDto findById(@PathVariable int id) {
		return service.findById(id);
	}
	

	/**Update the vehicle corresponding to the id given
	 * @param id : Id given
	 * @param vehicle : modified vehicle
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, VehicleDto vehicleDto) {
		service.update(id,vehicleDto);
	}
	
	/**Create a vehicle 
	 * @param vehicle : the new vehicle
	 */
	@PostMapping
	public void create(VehicleDto vehicleDto) {
		service.create(vehicleDto);
	}
	
	/**Delete the vehicle corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void delete(int id) {
		service.delete(id);
	}
}
