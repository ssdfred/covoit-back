package covoit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Carpool;
import covoit.repository.CarpoolRepository;

@Service
public class CarpoolService {
    @Autowired
    protected CarpoolRepository repository;

    /**
     * Get all the carpools in the database.
     *
     * @return A list of all the carpools
     */
    public List<Carpool> findAll() {
        return repository.findAll();
    }

    /**
     * Get the carpool corresponding to the given id.
     *
     * @param id The id of the carpool
     * @return An Optional containing the carpool if found, or an empty Optional
     */
    public Optional<Carpool> findById(int id) {
        return repository.findById(id);
    }

    /**
     * Update the carpool corresponding to the given id.
     *
     * @param id The id of the carpool to update
     * @param carpool The new carpool data
     * @return true if the update was successful, false otherwise
     */
    public boolean update(int id, Carpool carpool) {
        Optional<Carpool> carpoolDbOpt = repository.findById(id);
        if (carpoolDbOpt.isPresent()) {
            Carpool carpoolDb = carpoolDbOpt.get();
            // Assurez-vous que les propriétés à mettre à jour correspondent aux noms exacts dans votre entité Carpool
            carpoolDb.setAvailableSeat(carpool.getAvailableSeat());
            carpoolDb.setRoute(carpool.getRoute());
            carpoolDb.setVehicle(carpool.getVehicle());
            carpoolDb.setStartDate(carpool.getStartDate());
            repository.save(carpoolDb);
            return true;
        }
        return false;
    }

    /**
     * Create a new carpool.
     *
     * @param carpool The new carpool
     * @return true if the creation was successful, false otherwise
     */
    public boolean create(int id,Carpool carpool) {
        Optional<Carpool> carpoolDbOpt = repository.findById(carpool.getId());
        if (carpoolDbOpt.isPresent()) {
            return false;
        }
        repository.save(carpool);
        return true;
    }

    /**
     * Delete the carpool corresponding to the given id.
     *
     * @param id The id of the carpool to delete
     * @return true if the deletion was successful, false otherwise
     */
    public boolean delete(int id) {
        Optional<Carpool> carpoolDbOpt = repository.findById(id);
        if (carpoolDbOpt.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
