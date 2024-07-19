package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Booking;
import covoit.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	/**
	 * get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	public Booking findById(int id) {
		return bookingRepository.findById(id);
	}

	/**
	 * Update the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, Booking booking) {
		Booking bookingDB = findById(id);
		if (bookingDB == null) {
			return false;
		}
		bookingDB.setDriver(booking.getDriver());
		bookingDB.setServiceVehicle(booking.getServiceVehicle());
		bookingDB.setStartDate(booking.getStartDate());
		bookingDB.setEndDate(booking.getEndDate());
		bookingRepository.save(bookingDB);
		return true;
	}

	/**
	 * Create a Booking
	 * 
	 * @param Booking : the new Booking
	 * @return A confirmation message
	 */
	public boolean create(Booking booking) {
		Booking bookingDB = bookingRepository.findByStartDateAndEndDateAndDriver(booking.getStartDate(),
				booking.getEndDate(), booking.getDriver());
		if (bookingDB != null) {
			return false;
		}
		bookingRepository.save(booking);
		return true;
	}

	/**
	 * Delete the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean deleteBooking(int id) {
		Booking bookingDB = findById(id);
		if (bookingDB == null) {
			return false;
		}
		bookingRepository.deleteById(id);
		return true;
	}
}
