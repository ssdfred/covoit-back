package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Route;
import covoit.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository repository;

	public List<Route> findAll() {
		return (List<Route>) repository.findAll();
	}

	/**
	 * get the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Route
	 */
	public Route findById(int id) {
		return repository.findById(id);
	}

	/**
	 * Update the Route corresponding to the id given
	 * 
	 * @param id    : Id given
	 * @param route : modified route
	 * @return A confirmation message
	 */
	public boolean updateRoute(int id, Route object) {
		Route routeDB = findById(id);
		if (routeDB == null) {
			return false;
		}
		routeDB.setStartAddress(object.getStartAddress());
		;
		routeDB.setEndAddress(object.getEndAddress());
		routeDB.setKmTotal(object.getKmTotal());
		routeDB.setDuration(object.getDuration());
		repository.save(routeDB);
		return true;
	}

	/**
	 * Create a Route
	 * 
	 * @param Route : the new Route
	 */
	public boolean createRoute(Route object) {
		Route routeDB = repository.findByStartAddressAndEndAddress(object.getStartAddress(), object.getEndAddress());
		if (routeDB != null) {
			return false;
		}
		repository.save(object);
		return true;
	}

	/**
	 * Delete the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean deleteRoute(int id) {
		Route routeDB = findById(id);
		if (routeDB == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
