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
	public List<Booking> getBookings() {
		return service.getBookings();
	}
	
	/**get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	@GetMapping("/{id}")
	public Booking getBooking(@PathVariable int id) {
		return service.getBooking(id);
	}
	
	/**Update the booking corresponding to the id given
	 * @param id : Id given
	 * @param booking : modified booking
	 * @return A confirmation message
	 */
	@PutMapping("/{id}")
	public void updateBooking(@PathVariable int id, Booking booking) {
		service.updateBooking(id, booking);
	}
	
	/**Create an booking 
	 * @param booking : the new booking
	 * @return A confirmation message
	 */
	@PostMapping
	public void createBooking(Booking booking) {
		service.createBooking(booking);
	}
	
	/**Delete the booking corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	@DeleteMapping("/{id}")
	public void deleteBooking(int id) {
		service.deleteBooking(id);
	}
}
