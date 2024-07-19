package covoit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Booking;
import covoit.entities.UserAccount;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	Booking findById(int id);

	List<Booking> findAll();

	Booking findByStartDateAndEndDateAndDriver(LocalDateTime startDate, LocalDateTime endDate, UserAccount driver);
}
