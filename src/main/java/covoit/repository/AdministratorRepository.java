package covoit.repository;

import org.springframework.data.repository.CrudRepository;

import covoit.entities.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer> {

}
