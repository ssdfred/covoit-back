package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Vehicle;
import covoit.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getVehicles() {
		Iterable<Vehicle> iterable = vehicleRepository.findAll();
		List<Vehicle> vehicles = new ArrayList<>();
		iterable.forEach(vehicles::add);
		return vehicles;
	}

	/**
	 * get the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Vehicle
	 */
	public Vehicle getVehicle(int id) {
		return vehicleRepository.getById(id);
	}

	/**
	 * Update the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String updateVehicle(int id, Vehicle object) {
		Vehicle vehicleDB = getVehicle(id);
		vehicleDB.setBrand(object.getBrand());
		vehicleDB.setModel(object.getModel());
		vehicleDB.setCategory(object.getCategory());
		vehicleDB.setRegistration(object.getRegistration());
		vehicleDB.setNbSeat(object.getNbSeat());
		vehicleDB.setDrivers(object.getDrivers());
		vehicleRepository.save(vehicleDB);
		return "Le véhicule a été modifié";
	}

	/**
	 * Create an Vehicle
	 * 
	 * @param Vehicle : the new Vehicle
	 * @return A confirmation message
	 */
	public String createVehicle(Vehicle object) {
		vehicleRepository.save(object);
		return "Le véhicule a été créé";
	}

	/**
	 * Delete the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
		return "Le véhicule a été supprimé";
	}
}
