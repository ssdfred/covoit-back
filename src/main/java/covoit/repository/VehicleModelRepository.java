package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.VehicleModel;
@Repository
public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

	VehicleModel findById(int id);

	List<VehicleModel> findAll();

	VehicleModel findByName(String name);
}
