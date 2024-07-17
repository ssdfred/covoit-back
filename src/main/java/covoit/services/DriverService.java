package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Driver;
import covoit.repository.DriverRepository;

@Service
public class DriverService {
	@Autowired
	private DriverRepository driverRepository;
	
	public List<Driver> findAll() {
		return (List<Driver>) driverRepository.findAll();
	}
}
