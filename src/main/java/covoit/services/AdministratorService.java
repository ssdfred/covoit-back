package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Address;
import covoit.entities.Administrator;
import covoit.repository.AdministratorRepository;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;
	/**
	 * get all Administrator
	 * 
	 * @return An iterable object including all the addresses
	 */
	public List<Administrator> findAll() {
		return (List<Administrator>) administratorRepository.findAll();
	}
	

	/**get the admin corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return administrator
	 */
	public Optional<Administrator> findById(int id) {
		return administratorRepository.findById(id);
	}

	/**Update the admin corresponding to the id given
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public String update(Administrator admin) {
		administratorRepository.save(admin);
		return "L'adresse a été modifiée";
	}

	/**Create an admin 
	 * @param address : the new address
	 * @return A confirmation message
	 */
	public String create(Administrator admin) {
		administratorRepository.save(admin);
		return "L'adresse a été créée";
	}
	
	/**Delete the admin corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	public String delete(int id) {
		administratorRepository.deleteById(id);
		return "L'adresse a été supprimée";

	}
}
