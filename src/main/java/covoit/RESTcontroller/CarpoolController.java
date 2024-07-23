package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.CarpoolDto;
import covoit.services.CarpoolService;

@RestController
@RequestMapping("/carpools")
public class CarpoolController {

	@Autowired
	private CarpoolService carpoolService;

	/**
	 * Get all carpools.
	 *
	 * @return A list of all carpools.
	 */
	@GetMapping
	public List<CarpoolDto> getAllCarpools() {
		return carpoolService.findAll();
	}

	/**
	 * Get a specific carpool by ID.
	 *
	 * @param id The ID of the carpool to retrieve.
	 * @return The carpool if found, or a 404 status if not found.
	 */
	@GetMapping("/{id}")
	public CarpoolDto getCarpoolById(@PathVariable int id) {
		return carpoolService.findById(id);
	}

	/**
	 * Create a new carpool.
	 *
	 * @param carpool The carpool to create.
	 */
	@PostMapping
	public void create(@RequestBody CarpoolDto carpool) {
		carpoolService.create(carpool);

	}

	/**
	 * Update an existing carpool.
	 *
	 * @param id      The ID of the carpool to update.
	 * @param carpool The new carpool data.
	 * @return A response entity with a 204 status if successful, or a 404 status if
	 *         the carpool is not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateCarpool(@PathVariable int id, @RequestBody CarpoolDto carpool) {
		boolean updated = carpoolService.update(id, carpool);
		if (updated) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Delete a specific carpool by ID.
	 *
	 * @param id The ID of the carpool to delete.
	 * @return A response entity with a 204 status if successful, or a 404 status if
	 *         the carpool is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCarpool(@PathVariable int id) {
		boolean deleted = carpoolService.delete(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}