package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

	Booking getById(int id);

}
