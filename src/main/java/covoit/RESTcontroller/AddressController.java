package covoit.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.entities.Address;
import covoit.services.AddressService;

/**Define routes linked to Addresses
 * 
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressService service;
	
	/**Get all addresses
	 * 
	 */
	@GetMapping("/")
	public Iterable<Address> findAll() {
		return service.findAll();
	}
	
	/**get the address corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The address
	 */
	@GetMapping("/{id}")
	public Address findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**Update the address corresponding to the id given
	 * @param id : Id given
	 * @param address : modified address
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, Address address) {
		service.update(id, address);
	}
	
	/**Create an address 
	 * @param address : the new address
	 */
	@PostMapping
	public void create(Address address) {
		service.create(address);
	}

	/**Delete the address corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public void delete(int id) {
		service.delete(id);
	}
}
