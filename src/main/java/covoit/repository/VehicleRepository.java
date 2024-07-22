package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

	Vehicle findById(int id);

	List<Vehicle> findAll();

	Vehicle findByRegistration(String registration);

}
