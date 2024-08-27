package covoit.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.AddressDto;
import covoit.dtos.BookingDto;
import covoit.exception.AnomalieException;
import covoit.services.BookingService;
import jakarta.validation.Valid;

/**
 * Define routes linked to booking
 * 
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	private BookingService service;

	/*
	 * Get all bookings
	 * 
	 */
	@GetMapping
	public List<BookingDto> findAll() {
		return service.findAll();
	}

	/**
	 * get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	@GetMapping("/{id}")
	public BookingDto findById(@PathVariable int id) {
		return service.findById(id);
	}

	/**
	 * Update the booking corresponding to the id given
	 * 
	 * @param id      : Id given
	 * @param booking : modified booking
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, BookingDto booking) {
		service.update(id, booking);
	}

	/**
	 * Create an booking
	 * 
	 * @param booking : the new booking
	 */
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody BookingDto booking, BindingResult result)
			throws AnomalieException {
		if (!service.create(booking)) {
			throw new AnomalieException(result.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseEntity.ok("Creation reussi");
	}
	/**
	 * Delete the booking corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");

	}
}
