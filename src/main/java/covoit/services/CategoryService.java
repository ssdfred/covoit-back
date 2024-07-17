package covoit.services;

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
	public Iterable<Category> getCategories() {
		return repository.findAll();

	}
	
	/**get the category corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The category
	 */
	public Category getCategory(int id) {
		return repository.getById(id);
	}

	/**Update the category corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String updateAddress(Category category) {
		repository.save(category);
		return "La categorie a été modifiée";
	}
	
	/**Create a category 
	 * @param category : the new category
	 * @return A confirmation message
	 */
	public String createCategory(Category category) {
		repository.save(category);
		return "La catégorie a été créée";
	}

	/**Delete the category corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteCategory(int id) {
		repository.delete(repository.getById(id));
		return "La categorie a été supprimée";

	}
}
