package covoit.RESTcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.entities.Category;
import covoit.services.CategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private  CategoryService service;
	
	/**Get all addresses
	 * 
	 */
	@GetMapping("/")
	public List<Category> getAll() {
		return service.findAll();
	}
	
	/**get the address corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return The address
	 */
	@GetMapping("/{id}")
	public Category getById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**Update the  corresponding to the id given
	 * @param id : Id given
	 * @param address : modified address
	 * @return A confirmation message
	 */
	//TODO EXCEPTION ANOMALIE
	@PutMapping("/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id, @Valid @RequestBody Category category, BindingResult result )	 {
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body("Une erreur c'est produite");
		}
		service.update(id, category );
		return ResponseEntity.ok("L'update est un succes");
	}
	
	/**Create an  
	 * @param address : the new address
	 * @return A confirmation message
	 */
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody Category category, BindingResult result ) {
		if(!service.create(category)) {
			return ResponseEntity.badRequest().body("La creation n'a pas reussi !");
		}
		return ResponseEntity.ok("Creation reussi");
	}

	/**Delete the  corresponding to the id given
	 *  @param id : Id given
	 * @return A confirmation message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(int id) {
		if(!service.delete(id)) {
			return ResponseEntity.badRequest().body("La suppression a echoue !");
		}
		
		return ResponseEntity.ok("Suppression reussi>");
	}
}
