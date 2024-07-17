package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Administrator;
import covoit.repository.AdministratorRepository;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;
	
	public List<Administrator> findAll() {
		return (List<Administrator>) administratorRepository.findAll();
	}
}
