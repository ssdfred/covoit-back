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

import covoit.dtos.BrandDto;
import covoit.services.BrandService;

/**
 * Define routes linked to booking
 * 
 */
@RestController
@RequestMapping("/brands")
public class BrandControler {
	@Autowired
	private BrandService service;

	/*
	 * Get all brands
	 * 
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/")
	public List<BrandDto> findAll() {
		return service.findAll();
	}

	/**
	 * get the brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	@CrossOrigin("http://localhost:4200")
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
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/{id}")
	public void update(@PathVariable int id, BrandDto brand) {
		service.update(id, brand);
	}

	/**
	 * Create a brand
	 * 
	 * @param brand : the new brand
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping
	public void create(BrandDto brand) {
		service.create(brand);
	}

	/**
	 * Delete the brand corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");
	}
}
