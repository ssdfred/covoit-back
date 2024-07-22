package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Vehicle;
import covoit.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository repository;

	public List<Vehicle> findAll() {
		return repository.findAll();
	}

	/**
	 * get the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Vehicle
	 */
	public Vehicle findById(int id) {
		return repository.findById(id);
	}

	/**
	 * Update the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean updateVehicle(int id, Vehicle object) {
		Vehicle vehicleDB = findById(id);
		if(vehicleDB==null) {
			return false;
		}
		vehicleDB.setBrand(object.getBrand());
		vehicleDB.setModel(object.getModel());
		vehicleDB.setCategory(object.getCategory());
		vehicleDB.setRegistration(object.getRegistration());
		vehicleDB.setNbSeat(object.getNbSeat());
		vehicleDB.setDrivers(object.getDrivers());
		repository.save(vehicleDB);
		return true;
	}

	/**
	 * Create a Vehicle
	 * 
	 * @param Vehicle : the new Vehicle
	 * @return boolean
	 */
	public boolean createVehicle(Vehicle object) {
		Vehicle vehicleDB = repository.findByRegistration(object.getRegistration());
		if(vehicleDB!=null) {
			return false;
		}
		repository.save(object);
		return true;
	}

	/**
	 * Delete the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean deleteVehicle(int id) {
		Vehicle vehicleDB = findById(id);
		if(vehicleDB==null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
