package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.VehicleDto;
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
	@CrossOrigin("http://localhost:4200")
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
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/{id}")
	public VehicleDto findById(@PathVariable int id) {
		return service.findById(id);
	}
	

	/**Update the vehicle corresponding to the id given
	 * @param id : Id given
	 * @param vehicle : modified vehicle
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/{id}")
	public void update(@PathVariable int id, VehicleDto vehicleDto) {
		service.update(id,vehicleDto);
	}
	
	/**Create a vehicle 
	 * @param vehicle : the new vehicle
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping
	public void create(VehicleDto vehicleDto) {
		service.create(vehicleDto);
	}
	
	/**Delete the vehicle corresponding to the id given
	 *  @param id : Id given
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");
	}
}
