package covoit.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Address;
/**
 * This class is the repository associated with the class Address
 * 
 */
public interface AddressRepository extends CrudRepository<Address, Integer>{
	Address findById(int id);
	List<Address> findAll();
	Address findByDetailAndCityAndCountry(String detail, String city, String country);
}
