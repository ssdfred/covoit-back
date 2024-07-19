package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Booking;
import covoit.entities.Brand;
import covoit.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	public List<Brand> findAll() {
		return (List<Brand>) brandRepository.findAll();
	}
	/**get the Brand corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Brand
	 */
	public Optional<Brand> findById(int id) {
		return brandRepository.findById(id);
	}

	/**Update the Brand corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Brand object) {
		brandRepository.save(object);
		return "Brand a été modifiée";
	}

	/**Create an Brand 
	 * @param Brand : the new Brand
	 * @return A confirmation message
	 */
	public String create(Brand object) {
		brandRepository.save(object);
		return "Brand a été créée";
	}
	
	/**Delete the Brand corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		brandRepository.deleteById(id);
		return "Brand a été supprimée";
	}
}
