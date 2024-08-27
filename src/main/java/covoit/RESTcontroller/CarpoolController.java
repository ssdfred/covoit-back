package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.BrandDto;
import covoit.dtos.CarpoolDto;
import covoit.exception.AnomalieException;
import covoit.services.CarpoolService;
import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/carpools")
public class CarpoolController {

	@Autowired
	private CarpoolService service;

	/**
	 * Get all carpools.
	 *
	 * @return A list of all carpools.
	 */
	@GetMapping
	public List<CarpoolDto> getAllCarpools() {
		return service.findAll();
	}

	/**
	 * Get a specific carpool by ID.
	 *
	 * @param id The ID of the carpool to retrieve.
	 * @return The carpool if found, or a 404 status if not found.
	 */
	@GetMapping("/{id}")
	public CarpoolDto getCarpoolById(@PathVariable int id) {
		return service.findById(id);
	}

	/**
	 * Create a new carpool.
	 *
	 * @param carpool The carpool to create.
	 */
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody CarpoolDto carpool, BindingResult result)
			throws AnomalieException {
		if (!service.create(carpool)) {
			throw new AnomalieException(result.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseEntity.ok("Creation reussi");
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
		boolean updated = service.update(id, carpool);
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
	public ResponseEntity<String> deleteCarpool(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");
	}
}