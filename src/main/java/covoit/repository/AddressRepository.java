package covoit.repository;
import org.springframework.data.repository.CrudRepository;
import covoit.entities.Address;
/**
 * This class is the repository associated with the class Address
 * 
 */
public interface AddressRepository extends CrudRepository<Address, Integer>{
	Address getById(int id);

}
