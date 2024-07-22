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

import covoit.entities.Brand;
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

	/* Get all brands
	 * 
	 */
	@GetMapping("/")
	public List<Brand> findAll() {
		return service.findAll();
	}

	/**get the brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	@GetMapping("/{id}")
	public Brand findById(@PathVariable int id) {
		return service.findById(id);
	}

	/**Update the brand corresponding to the id given
	 * @param id : Id given
	 * @param brand : modified brand
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, Brand brand) {
		service.update(id, brand);
	}

	/**Create a brand 
	 * @param brand : the new brand
	 */
	@PostMapping
	public void create(Brand brand) {
		service.create(brand);
	}

	/**Delete the brand corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void delete(int id) {
		service.delete(id);
	}
}
