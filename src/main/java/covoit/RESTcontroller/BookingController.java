package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.entities.Booking;
import covoit.services.BookingService;

/**
 * Define routes linked to booking
 * 
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	private BookingService service;

	/* Get all bookings
	 * 
	 */
	@GetMapping("/")
	public List<Booking> findAll() {
		return service.findAll();
	}

	/**
	 * get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	@GetMapping("/{id}")
	public Booking findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**Update the booking corresponding to the id given
	 * @param id : Id given
	 * @param booking : modified booking
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, Booking booking) {
		service.update(id, booking);
	}
	
	/**Create an booking 
	 * @param booking : the new booking
	 */
	@PostMapping
	public void create(Booking booking) {
		service.create(booking);
	}
	
	/**Delete the booking corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void delete(int id) {
		service.delete(id);
	}
}
