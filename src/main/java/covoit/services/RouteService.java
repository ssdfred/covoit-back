package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.RouteDto;
import covoit.entities.Route;
import covoit.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository repository;

	public List<RouteDto> findAll() {
		List<Route> routes = repository.findAll();
		List<RouteDto> routesDto = new ArrayList<>();
		for(Route item :routes) {
			routesDto.add(new RouteDto().toDto(item));
		}
		return routesDto;
	}

	/**
	 * get the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Route
	 */
	public RouteDto findById(int id) {
		Route route = repository.findById(id);
		if (route == null) {
			return null;
		}
		return new RouteDto().toDto(route);
	}

	/**
	 * Update the Route corresponding to the id given
	 * 
	 * @param id    : Id given
	 * @param route : modified route
	 * @return A confirmation message
	 */
	public boolean update(int id, RouteDto object) {
		Route routeDB = repository.findById(id);
		if (routeDB == null) {
			return false;
		}
		Route change =object.toBean(object);
		routeDB.setDuration(change.getDuration());
		routeDB.setEndAddress(change.getEndAddress());
		routeDB.setKmTotal(change.getKmTotal());
		routeDB.setStartAddress(change.getStartAddress());
		repository.save(routeDB);
		return true;
	}

	/**
	 * Create a Route
	 * 
	 * @param Route : the new Route
	 */
	public boolean create(RouteDto object) {
		Route routeDB = repository.findByStartAddressAndEndAddress(object.getStartAddress(), object.getEndAddress());
		if (routeDB != null) {
			return false;
		}
		repository.save(object.toBean(object));
		return true;
	}

	/**
	 * Delete the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		Route routeDB = repository.findById(id);
		if (routeDB == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
