package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Category;

/**
 * This class is the repository associated with the class Category
 * 
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>{

	Category findById(int id);
	
	Category findByName(String name);
}
