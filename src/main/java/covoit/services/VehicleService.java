package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.VehicleDto;
import covoit.entities.Vehicle;
import covoit.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository repository;

	public List<VehicleDto> findAll() {
		List<Vehicle> vehicles = repository.findAll();
		List<VehicleDto> vehiclesDto = new ArrayList<>();
		for (Vehicle item : vehicles) {
			vehiclesDto.add(new VehicleDto().toDto(item));
		}
		return vehiclesDto;
	}

	/**
	 * get the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return Vehicle
	 */
	public VehicleDto findById(int id) {
		Vehicle vehicle = repository.findById(id);
		if (vehicle == null) {
			return null;
		}
		return new VehicleDto().toDto(vehicle);
	}

	/**
	 * Update the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, VehicleDto vehicleDto) {
		Vehicle vehicle = repository.findById(id);
		if (vehicle == null) {
			return false;
		}
		Vehicle change = vehicleDto.toBean(vehicleDto);
		vehicle.setBrand(change.getBrand());
		vehicle.setCategory(change.getCategory());
		vehicle.setDrivers(change.getDrivers());
		vehicle.setModel(change.getModel());
		vehicle.setNbSeat(change.getNbSeat());
		vehicle.setRegistration(change.getRegistration());
		repository.save(vehicle);
		return true;
	}

	/**
	 * Create a Vehicle
	 * 
	 * @param Vehicle : the new Vehicle
	 * @return boolean
	 */
	public boolean create(VehicleDto object) {
		Vehicle vehicleDB = repository.findByRegistration(object.getRegistration());
		if (vehicleDB != null) {
			return false;
		}
		repository.save(object.toBean(object));
		return true;
	}

	/**
	 * Delete the Vehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		Vehicle vehicleDB = repository.findById(id);
		if (vehicleDB == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
