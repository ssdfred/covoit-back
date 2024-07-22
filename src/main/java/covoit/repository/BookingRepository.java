package covoit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Booking;
import covoit.entities.UserAccount;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	Booking findById(int id);

	List<Booking> findAll();

	Booking findByStartDateAndEndDateAndDriver(LocalDateTime startDate, LocalDateTime endDate, UserAccount driver);
}
