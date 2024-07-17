package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Vehicle;
import covoit.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll() {
		return (List<Vehicle>) vehicleRepository.findAll();
	}
}
