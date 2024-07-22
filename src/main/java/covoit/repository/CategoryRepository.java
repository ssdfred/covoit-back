package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Category;

/**
 * This class is the repository associated with the class Category
 * 
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

	Category findById(int id);
	List<Category> findAll();
	Category findByName(String name);
}
