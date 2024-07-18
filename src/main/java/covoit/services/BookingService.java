package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import covoit.entities.Booking;
import covoit.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> findAll() {
		return (List<Booking>) bookingRepository.findAll();
	}

	/**get the Booking corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Booking
	 */
	public Optional<Booking> findById(int id) {
		return bookingRepository.findById(id);
	}

	/**Update the Booking corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Booking admin) {
		bookingRepository.save(admin);
		return "Booking a été modifiée";
	}

	/**Create an Booking 
	 * @param Booking : the new Booking
	 * @return A confirmation message
	 */
	public String create(Booking admin) {
		bookingRepository.save(admin);
		return "Booking a été créée";
	}
	
	/**Delete the Booking corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		bookingRepository.deleteById(id);
		return "Booking a été supprimée";
	}
}
