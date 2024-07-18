package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Route;
import covoit.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository routeRepository;
	
	public List<Route> getRoutes() {
		return (List<Route>) routeRepository.findAll();
	}
	/**get the Route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Route
	 */
	public Optional<Route> findById(int id) {
		return routeRepository.findById(id);
	}

	/**Update the Route corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Route object) {
		routeRepository.save(object);
		return "Route a été modifiée";
	}

	/**Create an Route 
	 * @param Route : the new Route
	 * @return A confirmation message
	 */
	public String create(Route object) {
		routeRepository.save(object);
		return "Route a été créée";
	}
	
	/**Delete the Route corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		routeRepository.deleteById(id);
		return "Route a été supprimée";
	}
}
