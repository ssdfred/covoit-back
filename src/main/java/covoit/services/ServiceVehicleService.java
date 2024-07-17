package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.ServiceVehicle;
import covoit.repository.ServiceVehicleRepository;

@Service
public class ServiceVehicleService {
	@Autowired
	private ServiceVehicleRepository serviceVehicleRepository;
	
	public List<ServiceVehicle> findAll() {
		return (List<ServiceVehicle>) serviceVehicleRepository.findAll();
	}
}
