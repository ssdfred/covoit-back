package covoit.repository;
import org.springframework.data.repository.CrudRepository;
import covoit.entities.Address;
/**
 * This class the repository associated with the class Address
 * 
 */
public interface AddressRepository extends CrudRepository<Address, Integer>{
	Address getById(int id);

}
