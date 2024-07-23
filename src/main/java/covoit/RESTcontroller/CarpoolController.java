package covoit.RESTcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covoit.entities.Carpool;
import covoit.services.CarpoolService;

@RestController
@RequestMapping("/carpools")
public class CarpoolController {

    @Autowired
    private CarpoolService carpoolService;

    /**
     * Get all carpools.
     *
     * @return A list of all carpools.
     */
    @GetMapping
    public List<Carpool> getAllCarpools() {
        return carpoolService.findAll();
    }

    /**
     * Get a specific carpool by ID.
     *
     * @param id The ID of the carpool to retrieve.
     * @return The carpool if found, or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Carpool> getCarpoolById(@PathVariable int id) {
        Optional<Carpool> carpool = carpoolService.findById(id);
        return carpool.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new carpool.
     *
     * @param carpool The carpool to create.
     * @return A response entity with the created carpool and a 201 status.
     */
    @PostMapping
    public ResponseEntity<Carpool> createCarpool(@RequestBody Carpool carpool) {
        boolean created = carpoolService.create(carpool);
        if (created) {
            return new ResponseEntity<>(carpool, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    /**
     * Update an existing carpool.
     *
     * @param id The ID of the carpool to update.
     * @param carpool The new carpool data.
     * @return A response entity with a 204 status if successful, or a 404 status if the carpool is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCarpool(@PathVariable int id, @RequestBody Carpool carpool) {
        boolean updated = carpoolService.update(id, carpool);
        if (updated) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a specific carpool by ID.
     *
     * @param id The ID of the carpool to delete.
     * @return A response entity with a 204 status if successful, or a 404 status if the carpool is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarpool(@PathVariable int id) {
        boolean deleted = carpoolService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}