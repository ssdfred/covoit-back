package covoit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
