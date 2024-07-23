package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.BrandDto;
import covoit.entities.Brand;
import covoit.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;

	public List<BrandDto> findAll() {
		List<Brand> brands = brandRepository.findAll();
		List<BrandDto> brandsDto = new ArrayList<>();
		for (Brand item : brands) {
			brandsDto.add(new BrandDto().toDto(item));
		}
		return brandsDto;
	}

	/**
	 * get the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	public BrandDto findById(int id) {
		Brand brand = brandRepository.findById(id);
		if (brand == null) {
			return null;
		}
		return new BrandDto().toDto(brand);
	}

	/**
	 * Update the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, BrandDto object) {
		Brand brandDB = brandRepository.findById(id);
		if (brandDB == null) {
			return false;
		}
		brandDB = object.toBean(object);
		brandRepository.save(brandDB);
		return true;
	}

	/**
	 * Create a Brand
	 * 
	 * @param Brand : the new Brand
	 * @return A confirmation message
	 */
	public boolean create(BrandDto object) {
		Brand brandDB = brandRepository.findByName(object.getName());
		if (brandDB != null) {
			return false;
		}
		brandRepository.save(object.toBean(object));
		return true;
	}

	/**
	 * Delete the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		Brand brandDB = brandRepository.findById(id);
		if (brandDB == null) {
			return false;
		}
		brandRepository.deleteById(id);
		return true;
	}
}
