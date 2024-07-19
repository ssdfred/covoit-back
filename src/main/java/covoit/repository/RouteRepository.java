package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Address;
import covoit.entities.Route;

public interface RouteRepository extends CrudRepository<Route, Integer> {

	Route findById(int id);

	List<Route> findAll();

	Route findByStartAddressAndEndAddress(Address startAddress, Address endAddress);
}
