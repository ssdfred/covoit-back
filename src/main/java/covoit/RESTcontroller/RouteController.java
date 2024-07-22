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
	public Iterable<Route> findAll() {
		return service.findAll();
	}

	/**
	 * get the route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The route
	 */
	@GetMapping("/{id}")
	public Route findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**Update the route corresponding to the id given
	 * @param id : Id given
	 * @param route : modified route
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, Route route) {
		service.update(id, route);
	}
	
	/**Create a route 
	 * @param route : the new route
	 */
	@PostMapping
	public void create(Route route) {
		service.create(route);
	}

	/**Delete the route corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void delete(int id) {
		service.delete(id);}
	
}
