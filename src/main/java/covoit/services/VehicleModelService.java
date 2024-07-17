package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.VehicleModel;
import covoit.repository.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	public List<VehicleModel> findAll() {
		return (List<VehicleModel>) vehicleModelRepository.findAll();
	}
}
