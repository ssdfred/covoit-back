package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Brand;
import covoit.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	public List<Brand> findAll() {
		return (List<Brand>) brandRepository.findAll();
	}
}
