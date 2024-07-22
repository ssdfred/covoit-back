package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.ServiceVehicle;
@Repository
public interface ServiceVehicleRepository extends CrudRepository<ServiceVehicle, Integer> {
	ServiceVehicle findById(int id);

	List<ServiceVehicle> findAll();

	ServiceVehicle findByRegistration(String registration);
}
