package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Booking;
import covoit.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> getBookings() {
		Iterable<Booking> iterable = bookingRepository.findAll();
		List<Booking> bookings = new ArrayList<>();
		iterable.forEach(bookings::add);
		return bookings;
	}

	/**
	 * get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	public Booking getBooking(int id) {
		return bookingRepository.getById(id);
	}

	/**
	 * Update the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String updateBooking(int id,Booking booking) {
		Booking bookingDB = getBooking(id);
		bookingDB.setDriver(booking.getDriver());
		bookingDB.setServiceVehicle(booking.getServiceVehicle());
		bookingDB.setStartDate(booking.getStartDate());
		bookingDB.setEndDate(booking.getEndDate());
		bookingRepository.save(bookingDB);
		return "La réservation a été modifiée";
	}

	/**
	 * Create a Booking
	 * 
	 * @param Booking : the new Booking
	 * @return A confirmation message
	 */
	public String createBooking(Booking admin) {
		bookingRepository.save(admin);
		return "La réservation a été créée";
	}

	/**
	 * Delete the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteBooking(int id) {
		bookingRepository.deleteById(id);
		return "La réservation a été supprimée";
	}
}
