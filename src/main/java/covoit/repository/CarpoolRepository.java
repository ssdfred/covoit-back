package covoit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import covoit.entities.Carpool;

/**
 * Repository for Carpool entity.
 */
@Repository
public interface CarpoolRepository extends JpaRepository<Carpool, Integer> {
    /**
     * Finds all carpools associated with a specific user account.
     *
     * @param userId the ID of the user account
     * @return a list of carpools associated with the user
     */
    List<Carpool> findByUserAccounts_Id(int userId);
    Carpool findById(int id);
	List<Carpool> findAll();

}
