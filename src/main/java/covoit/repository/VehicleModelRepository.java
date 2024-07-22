package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.VehicleModel;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

	VehicleModel findById(int id);

	List<VehicleModel> findAll();

	VehicleModel findByName(String name);
}
