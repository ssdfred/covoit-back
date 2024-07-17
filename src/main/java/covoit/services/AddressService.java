package covoit.services;

import org.springframework.beans.factory.annotation.Autowired;

import covoit.entities.Address;
import covoit.repository.AddressRepository;

public class AddressService {
	@Autowired
	protected AddressRepository repository;
	
	public Iterable<Address> getAdresses(){
		return repository.findAll();
		
	}
	
	public Address getAddress(int id) {
		return repository.getById(id);
	}
	
	public String updateAddress(Address address) {
		repository.save(address);
		return "L'adresse a été modifiée";
	}
	
	public String createAddress(Address address) {
		repository.save(address);
		return "L'adresse a été créée";
	}
	
	public String deleteAddress(int id) {
		repository.delete(repository.getById(id));
		return "L'adresse a été supprimée";
		
	}
	

}
