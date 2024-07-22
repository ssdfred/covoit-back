package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
	Brand findById(int id);

	List<Brand> findAll();

	Brand findByName(String name);
}
