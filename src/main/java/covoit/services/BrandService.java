package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Brand;
import covoit.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	/**
	 * get the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	public Brand findById(int id) {
		return brandRepository.findById(id);
	}

	/**
	 * Update the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, Brand object) {
		Brand brandDB = findById(id);
		if (brandDB == null) {
			return false;
		}
		brandDB.setName(object.getName());
		brandDB.setVehicles(object.getVehicles());
		brandRepository.save(brandDB);
		return true;
	}

	/**
	 * Create a Brand
	 * 
	 * @param Brand : the new Brand
	 * @return A confirmation message
	 */
	public boolean create(Brand object) {
		Brand brandDB = brandRepository.findByName(object.getName());
		if (brandDB != null) {
			return false;
		}
		brandRepository.save(object);
		return true;
	}

	/**
	 * Delete the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean deleteBrand(int id) {
		Brand brandDB = brandRepository.findById(id);
		if (brandDB == null) {
			return false;
		}
		brandRepository.deleteById(id);
		return true;
	}
}
