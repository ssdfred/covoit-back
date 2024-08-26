package covoit.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.dtos.AddressDto;
import covoit.services.AddressService;

/**Define routes linked to Addresses
 * 
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressService service;
	
	/**Get all addresses
	 * 
	 */
	@GetMapping("/")
	public Iterable<AddressDto> findAll() {
		return service.findAll();
	}
	
	/**get the address corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The address
	 */
	@GetMapping("/{id}")
	public AddressDto findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**Update the address corresponding to the id given
	 * @param id : Id given
	 * @param address : modified address
	 */
	@PutMapping("/{id}")
	public void update(@PathVariable int id, AddressDto addressDto) {
		service.update(id, addressDto);
	}
	
	/**Create an address 
	 * @param address : the new address
	 */
	@PostMapping
	public void create(AddressDto addressDto) {
		service.create(addressDto);
	}

	/**Delete the address corresponding to the id given
	 *  @param id : Id given
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Suppression reussie");
	}
}
