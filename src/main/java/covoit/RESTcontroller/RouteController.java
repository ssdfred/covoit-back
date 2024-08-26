package covoit.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.RouteDto;
import covoit.services.RouteService;

/**
 * Define routes linked to Addresses
 * 
 */
@CrossOrigin("http://localhost:4200")
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
	public Iterable<RouteDto> findAll() {
		return service.findAll();
	}

	/**
	 * get the route corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The route
	 */
	@GetMapping("/{id}")
	public RouteDto findById(@PathVariable int id) {
		return service.findById(id);
	}

	/**
	 * Update the route corresponding to the id given
	 * 
	 * @param id    : Id given
	 * @param route : modified route
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, RouteDto route) {
		service.update(id, route);
	}

	/**
	 * Create a route
	 * 
	 * @param route : the new route
	 */
	@PostMapping
	public void create(RouteDto route) {
		service.create(route);
	}

	/**
	 * Delete the route corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public  ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");

	}

}
