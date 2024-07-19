package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Category;

/**
 * This class is the repository associated with the class Category
 * 
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>{

	Category findById(int id);
	List<Category> findAll();
	Category findByName(String name);
}
