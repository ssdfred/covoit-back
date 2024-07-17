package covoit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
	
}
