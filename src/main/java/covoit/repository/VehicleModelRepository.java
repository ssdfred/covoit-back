package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.VehicleModel;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

}
