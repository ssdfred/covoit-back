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
import covoit.dtos.CategoryDto;
import covoit.exception.AnomalieException;
import covoit.services.BrandService;
import jakarta.validation.Valid;

/**
 * Define routes linked to booking
 * 
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/brands", produces = "application/json")
public class BrandControler {
	@Autowired
	private BrandService service;

	/*
	 * Get all brands
	 * 
	 */
	@GetMapping
	public List<BrandDto> findAll() {
		return service.findAll();
	}

	/**
	 * get the brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	@GetMapping("/{id}")
	public BrandDto findById(@PathVariable int id) {
		return service.findById(id);
	}

	/**
	 * Update the brand corresponding to the id given
	 * 
	 * @param id    : Id given
	 * @param brand : modified brand
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, BrandDto brand) {
		service.update(id, brand);
	}

	/**
	 * Create a brand
	 * 
	 * @param brand : the new brand
	 */
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody BrandDto brand, BindingResult result)
			throws AnomalieException {
		if (!service.create(brand)) {
			throw new AnomalieException(result.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseEntity.ok("Creation reussi");
	}
	/**
	 * Delete the brand corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");
	}
}
