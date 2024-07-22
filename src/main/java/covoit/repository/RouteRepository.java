package covoit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Address;
import covoit.entities.Route;
@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {

	Route findById(int id);

	List<Route> findAll();

	Route findByStartAddressAndEndAddress(Address startAddress, Address endAddress);
}
