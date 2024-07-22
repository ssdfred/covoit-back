package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.ServiceVehicle;
import covoit.repository.ServiceVehicleRepository;

@Service
public class ServiceVehicleService {
	@Autowired
	private ServiceVehicleRepository repository;

	public List<ServiceVehicle> findAll() {
		return repository.findAll();
	}

	/**
	 * get the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return ServiceVehicle
	 */
	public ServiceVehicle findById(int id) {
		return repository.findById(id);
	}

	/**
	 * Update the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	public boolean update(int id, ServiceVehicle object) {
		ServiceVehicle sVehicleDB = repository.findById(id);
		if (sVehicleDB == null) {
			return false;
		}
		sVehicleDB.setState(object.getState());
		sVehicleDB.setRegistration(object.getRegistration());
		sVehicleDB.setBrand(object.getBrand());
		sVehicleDB.setModel(object.getModel());
		sVehicleDB.setCategory(object.getCategory());
		sVehicleDB.setCo2Km(object.getCo2Km());
		sVehicleDB.setMotorization(object.getMotorization());
		sVehicleDB.setPicture(object.getPicture());
		sVehicleDB.setNbSeat(object.getNbSeat());
		repository.save(object);
		return true;
	}

	/**
	 * Create a ServiceVehicle
	 * 
	 * @param ServiceVehicle : the new ServiceVehicle
	 * @return boolean
	 */
	public boolean create(ServiceVehicle object) {
		ServiceVehicle sVehicleDB = repository.findByRegistration(object.getRegistration());
		if (sVehicleDB != null) {
			return false;
		}
		repository.save(object);
		return true;
	}

	/**
	 * Delete the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		ServiceVehicle sVehicleDB = repository.findById(id);
		if (sVehicleDB == null) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
