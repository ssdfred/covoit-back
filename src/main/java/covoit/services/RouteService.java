package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Route;
import covoit.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository routeRepository;

	public List<Route> getRoutes() {
		Iterable<Route> itRoutes = routeRepository.findAll();
		List<Route> listeRoutes = new ArrayList<>();
		itRoutes.forEach(listeRoutes::add);
		return listeRoutes;
	}

	/**
	 * get the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Route
	 */
	public Route getRoute(int id) {
		return routeRepository.getById(id);
	}

	/**
	 * Update the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @param route : modified route
	 * @return A confirmation message
	 */
	public String updateRoute(int id, Route object) {
		Route routeToChange = getRoute(id);
		routeToChange.setStartAddress(object.getStartAddress());;
		routeToChange.setEndAddress(object.getEndAddress());
		routeToChange.setKmTotal(object.getKmTotal());
		routeToChange.setDuration(object.getDuration());
		routeRepository.save(routeToChange);
		return "Le trajet a été modifié";
	}

	/**
	 * Create an Route
	 * 
	 * @param Route : the new Route
	 * @return A confirmation message
	 */
	public String createRoute(Route object) {
		routeRepository.save(object);
		return "Route a été créée";
	}

	/**
	 * Delete the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteRoute(int id) {
		routeRepository.deleteById(id);
		return "Route a été supprimée";
	}
}
