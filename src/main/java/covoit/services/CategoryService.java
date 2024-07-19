package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import covoit.entities.Category;
import covoit.repository.CategoryRepository;

/**
 * This class is for the methods associated with the class Category
 * 
 */
public class CategoryService {
	@Autowired
	protected CategoryRepository repository;
	
	/**
	 * get all the categories in base
	 * 
	 * @return An iterable object including all the categories
	 */
	public List<Category> findAll() {
		return repository.findAll();

	}
	
	/**get the category corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The category
	 */
	public Category findById(int id) {
		return repository.findById(id);
	}

	/**Update the category corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public void update(int id, Category category) {
		Category categoryDb = repository.findById(id);
		categoryDb.setName(category.getName());
		categoryDb.setVehicles(category.getVehicles());
		
		repository.save(categoryDb);
	}
	
	/**Create a category 
	 * @param category : the new category
	 * @return A confirmation message
	 */
	public boolean create(Category category) {
		Category categoryDb = repository.findByName(category.getName());
		if(categoryDb.equals(category)) {
			return false;
		}
		repository.save(category);
		return true;
	}

	/**Delete the category corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		Category categoryDb = repository.findById(id);
		if(categoryDb == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
