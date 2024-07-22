package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Address;
import covoit.repository.AddressRepository;

/**
 * This class is for the methods associated with the class Address
 * 
 */
@Service
public class AddressService {
	@Autowired
	protected AddressRepository repository;

	/**
	 * get all the addresses in base
	 * 
	 * @return An iterable object including all the addresses
	 */
	public List<Address> findAll() {
		return repository.findAll();

	}

	/**
	 * get the address corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The address
	 */
	public Address findById(int id) {
		return repository.findById(id);
	}

	/**
	 * Update the address corresponding to the id given
	 * 
	 * @param id      : Id given
	 * @param address : modified address
	 * @return A confirmation message
	 */
	public boolean update(int id, Address address) {
		Address addressDB = findById(id);
		if (addressDB == null) {
			return false;
		}
		addressDB.setDetail(address.getDetail());
		addressDB.setCity(address.getCity());
		addressDB.setCountry(address.getCountry());
		repository.save(addressDB);
		return true;
	}

	/**
	 * Create an address
	 * 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public boolean create(Address address) {
		Address addressDb = repository.findByDetailAndCityAndCountry(address.getDetail(), address.getCity(),
				address.getCountry());
		if (addressDb == null) {
			repository.save(address);
			return true;
		}
		return false;
	}

	/**
	 * Delete the address corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	public boolean delete(int id) {
		Address addressDb = findById(id);
		if (addressDb == null) {
			return false;
		}
		repository.deleteById(id);
		return true;

	}
}
