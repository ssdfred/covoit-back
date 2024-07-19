package covoit.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.entities.Route;
import covoit.services.RouteService;

/**
 * Define routes linked to Addresses
 * 
 */
@RestController
@RequestMapping("/routes")
public class RouteController {
	@Autowired
	private RouteService service;

	/**
	 * Get all routes
	 * 
	 */
	@GetMapping("/")
	public Iterable<Route> getRoutes() {
		return service.findAll();
	}

	/**
	 * get the route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The route
	 */
	@GetMapping("/{id}")
	public Route getRoute(@PathVariable int id) {
		return service.getRoute(id);
	}
	
	/**Update the route corresponding to the id given
	 * @param id : Id given
	 * @param route : modified route
	 */
	@PutMapping("/{id}")
	public void updateRoute(@PathVariable int id, Route route) {
		service.updateRoute(id, route);
	}
	
	/**Create a route 
	 * @param route : the new route
	 */
	@PostMapping
	public void createRoute(Route route) {
		service.createRoute(route);
	}

	/**Delete the route corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void deleteRoute(int id) {
		service.deleteRoute(id);}
	
}
