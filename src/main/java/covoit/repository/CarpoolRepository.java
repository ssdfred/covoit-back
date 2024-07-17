package covoit.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import covoit.dtos.CarpoolDTO;
import covoit.entities.Carpool;

/**
 * Repository for Carpool entity.
 */
@Repository
public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
    /**
     * Finds all carpools associated with a specific user account.
     *
     * @param userId the ID of the user account
     * @return a list of carpools associated with the user
     */
    List<Carpool> findByUserAccounts_Id(Long userId);
}
