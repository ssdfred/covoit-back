package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.BookingDto;
import covoit.entities.Booking;
import covoit.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	public List<BookingDto> findAll() {
		List<Booking> bookings = bookingRepository.findAll();
		List<BookingDto> bookingsDto = new ArrayList<>();
		for (Booking item : bookings) {
			bookingsDto.add(new BookingDto().toDto(item));
		}
		return bookingsDto;
	}

	/**
	 * get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	public BookingDto findById(int id) {
		Booking booking = bookingRepository.findById(id);
		if (booking == null) {
			return null;
		}
		return new BookingDto().toDto(booking);
	}

	/**
	 * Update the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, BookingDto bookingDto) {
		Booking bookingDB = bookingRepository.findById(id);
		if (bookingDB == null) {
			return false;
		}
		Booking change =  bookingDto.toBean(bookingDto);
		bookingDB.setDriver(change.getDriver());
		bookingDB.setEndDate(change.getEndDate());
		bookingDB.setServiceVehicle(change.getServiceVehicle());
		bookingDB.setStartDate(change.getStartDate());
		bookingRepository.save(bookingDB);
		return true;
	}

	/**
	 * Create a Booking
	 * 
	 * @param Booking : the new Booking
	 * @return A confirmation message
	 */
	public boolean create(BookingDto bookingDto) {
		Booking bookingDB = bookingRepository.findByStartDateAndEndDateAndDriver(bookingDto.getStartDate(),
				bookingDto.getEndDate(), bookingDto.getDriver());
		if (bookingDB != null) {
			return false;
		}
		bookingRepository.save(bookingDto.toBean(bookingDto));
		return true;
	}

	/**
	 * Delete the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		Booking bookingDB = bookingRepository.findById(id);
		if (bookingDB == null) {
			return false;
		}
		bookingRepository.deleteById(id);
		return true;
	}
}
