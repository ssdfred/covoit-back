package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Route;

public interface RouteRepository extends CrudRepository<Route, Integer> {

	Route getById(int id);

}
