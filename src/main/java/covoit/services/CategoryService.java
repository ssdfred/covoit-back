package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.CategoryDto;
import covoit.entities.Category;
import covoit.repository.CategoryRepository;

/**
 * This class is for the methods associated with the class Category
 * 
 */
@Service
public class CategoryService {
	@Autowired
	protected CategoryRepository repository;

	/**
	 * get all the categories in base
	 * 
	 * @return An iterable object including all the categories
	 */
	public List<CategoryDto> findAll() {
		List<Category> categories = repository.findAll();
		List<CategoryDto> categoriesDto = new ArrayList<>();
		for (Category item : categories) {
			categoriesDto.add(new CategoryDto().toDto(item));
		}
		return categoriesDto;

	}

	/**
	 * get the category corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The category
	 */
	public CategoryDto findById(int id) {
		Category category = repository.findById(id);
		if (category == null) {
			return null;
		}
		return new CategoryDto().toDto(category);
	}

	/**
	 * Update the category corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, CategoryDto categoryDto) {
		Category categoryDb = repository.findById(id);
		if (categoryDb == null) {
			return false;
		}
		categoryDb = categoryDto.toBean(categoryDto);
		repository.save(categoryDb);
		return true;
	}

	/**
	 * Create a category
	 * 
	 * @param category : the new category
	 * @return A confirmation message
	 */
	public boolean create(CategoryDto categoryDto) {
		Category categoryDb = repository.findByName(categoryDto.getName());
		if (categoryDb != null) {
			return false;
		}
		repository.save(categoryDto.toBean(categoryDto));
		return true;
	}

	/**
	 * Delete the category corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		Category categoryDb = repository.findById(id);
		if (categoryDb == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
