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

import covoit.entities.Booking;
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
	public List<Brand> getBrands() {
		return service.getBookings();
	}

	/**get the brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	@GetMapping("/{id}")
	public Brand getBrand(@PathVariable int id) {
		return service.getBrand(id);
	}

	/**Update the brand corresponding to the id given
	 * @param id : Id given
	 * @param brand : modified brand
	 */
	@PutMapping("/{id}")
	public void updateBrand(@PathVariable int id, Brand brand) {
		service.updateBrand(id, brand);
	}

	/**Create a brand 
	 * @param brand : the new brand
	 */
	@PostMapping
	public void createBrand(Brand brand) {
		service.createBrand(brand);
	}

	/**Delete the brand corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void deleteBrand(int id) {
		service.deleteBrand(id);
	}
}
