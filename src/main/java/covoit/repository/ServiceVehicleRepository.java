package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.ServiceVehicle;

public interface ServiceVehicleRepository extends CrudRepository<ServiceVehicle, Integer> {
	ServiceVehicle findById(int id);

	List<ServiceVehicle> findAll();

	ServiceVehicle findByRegistration(String registration);
}
