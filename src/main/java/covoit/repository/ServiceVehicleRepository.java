package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.ServiceVehicle;

public interface ServiceVehicleRepository extends CrudRepository<ServiceVehicle, Integer> {

}
