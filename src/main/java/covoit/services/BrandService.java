package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Brand;
import covoit.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;

	public List<Brand> getBookings() {
		Iterable<Brand> iterable = brandRepository.findAll();
		List<Brand> brands = new ArrayList<>();
		iterable.forEach(brands::add);
		return brands;
	}

	/**
	 * get the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	public Brand getBrand(int id) {
		return brandRepository.getById(id);
	}

	/**
	 * Update the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String updateBrand(int id,Brand object) {
		Brand brandDB = getBrand(id);
		brandDB.setName(object.getName());
		brandDB.setVehicles(object.getVehicles());
		brandRepository.save(brandDB);
		return "La marque a été modifiée";
	}

	/**
	 * Create a Brand
	 * 
	 * @param Brand : the new Brand
	 * @return A confirmation message
	 */
	public String createBrand(Brand object) {
		brandRepository.save(object);
		return "La marque a été créée";
	}

	/**
	 * Delete the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteBrand(int id) {
		brandRepository.deleteById(id);
		return "Brand a été supprimée";
	}
}
