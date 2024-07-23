package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.AddressDto;
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
	public List<AddressDto> findAll() {
		List<Address> address = repository.findAll();
		List<AddressDto> addressDto = new ArrayList<>();
		for(Address item : address) {
			addressDto.add(new AddressDto().toDTO(item));
		}
		
		return addressDto;

	}

	/**
	 * get the address corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The address
	 */
	public AddressDto findById(int id) {
		Address address = repository.findById(id);
		if(address == null) {
			return null;
		}
		return new AddressDto().toDTO(address);
	}

	/**
	 * Update the address corresponding to the id given
	 * 
	 * @param id      : Id given
	 * @param address : modified address
	 * @return A confirmation message
	 */
	public boolean update(int id, AddressDto addressDto) {
		Address addressDB = repository.findById(id);
		if (addressDB == null) {
			return false;
		}
		addressDB = addressDto.toBean(addressDto);
		repository.save(addressDB);
		return true;
	}

	/**
	 * Create an address
	 * 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public boolean create(AddressDto addressDto) {
		Address addressDb = repository.findByDetailAndCityAndCountry(addressDto.getDetail(), addressDto.getCity(),
				addressDto.getCountry());
		if (addressDb == null) {
			repository.save(addressDto.toBean(addressDto));
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
		Address addressDb = repository.findById(id);
		if (addressDb == null) {
			return false;
		}
		repository.deleteById(id);
		return true;

	}
}
