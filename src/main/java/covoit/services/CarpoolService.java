package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.CarpoolDto;
import covoit.entities.Carpool;
import covoit.repository.CarpoolRepository;

@Service
public class CarpoolService {
	@Autowired
	protected CarpoolRepository repository;

	/**
	 * Get all the carpools in the database.
	 *
	 * @return A list of all the carpools
	 */
	public List<CarpoolDto> findAll() {
		List<Carpool> carpools = repository.findAll();
		List<CarpoolDto> carpoolsDto = new ArrayList<>();
		for (Carpool item : carpools) {
			carpoolsDto.add(new CarpoolDto().toDTO(item));
		}
		return carpoolsDto;
	}

	/**
	 * Get the carpool corresponding to the given id.
	 *
	 * @param id The id of the carpool
	 * @return An Optional containing the carpool if found, or an empty Optional
	 */
	public CarpoolDto findById(int id) {
		Carpool carpool = repository.findById(id);
		if (carpool == null) {
			return null;
		}
		return new CarpoolDto().toDTO(carpool);
	}

	/**
	 * Update the carpool corresponding to the given id.
	 *
	 * @param id      The id of the carpool to update
	 * @param carpool The new carpool data
	 * @return true if the update was successful, false otherwise
	 */
	public boolean update(int id, CarpoolDto carpool) {
		Carpool carpoolDb = repository.findById(id);
		if (carpoolDb == null) {
			return false;
		}
		Carpool change = carpool.toBean(carpool);
		carpoolDb.setAvailableSeat(change.getAvailableSeat());
		carpoolDb.setRoute(change.getRoute());
		carpoolDb.setStartDate(change.getStartDate());
		carpoolDb.setUserAccounts(change.getUserAccounts());
		carpoolDb.setVehicle(change.getVehicle());
		repository.save(carpoolDb);
		return true;
	}

	/**
	 * Create a new carpool.
	 *
	 * @param carpool The new carpool
	 * @return true if the creation was successful, false otherwise
	 */
	public boolean create(CarpoolDto carpoolDto) {
		Carpool carpoolDb = repository.findByStartDateAndVehicle(carpoolDto.getStartDate(), carpoolDto.getVehicle());
		if (carpoolDb != null) {
			return false;
		}
		repository.save(carpoolDto.toBean(carpoolDto));
		return true;
	}

	/**
	 * Delete the carpool corresponding to the given id.
	 *
	 * @param id The id of the carpool to delete
	 * @return true if the deletion was successful, false otherwise
	 */
	public boolean delete(int id) {
		Carpool carpoolDb = repository.findById(id);
		if (carpoolDb != null) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
