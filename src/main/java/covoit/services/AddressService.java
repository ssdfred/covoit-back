package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import covoit.entities.Address;
import covoit.repository.AddressRepository;

/**
 * This class is for the methods associated with the class Address
 * 
 */
public class AddressService {
	@Autowired
	protected AddressRepository repository;

	/**
	 * get all the addresses in base
	 * 
	 * @return An iterable object including all the addresses
	 */
	public List<Address> getAdresses() {
		Iterable<Address> itAddresses = repository.findAll();
		List<Address> addresses = new ArrayList<>();
		itAddresses.forEach(addresses::add);
		return addresses;

	}

	/**get the address corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The address
	 */
	public Address getAddress(int id) {
		return repository.getById(id);
	}

	/**Update the address corresponding to the id given
	 * @param id : Id given
	 * @param address : modified address
	 * @return A confirmation message
	 */
	public String updateAddress(int id, Address address) {
		Address addressToChange = getAddress(id);
		addressToChange.setDetail(address.getDetail());
		addressToChange.setCity(address.getCity());
		addressToChange.setCountry(address.getCountry());
		repository.save(addressToChange);
		return "L'adresse a été modifiée";
	}

	/**Create an address 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public String createAddress(Address address) {
		repository.save(address);
		return "L'adresse a été créée";
	}
	
	/**Delete the address corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String deleteAddress(int id) {
		repository.delete(repository.getById(id));
		return "L'adresse a été supprimée";

	}
}
