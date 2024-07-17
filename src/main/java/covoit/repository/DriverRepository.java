package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Driver;

public interface DriverRepository extends CrudRepository<Driver, Integer> {
	
}
