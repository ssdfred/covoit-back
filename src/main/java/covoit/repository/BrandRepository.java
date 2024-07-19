package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer> {

	Brand getById(int id);

}
