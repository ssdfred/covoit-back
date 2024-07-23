package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.ServiceVehicleDto;
import covoit.entities.ServiceVehicle;
import covoit.repository.ServiceVehicleRepository;

@Service
public class ServiceVehicleService {
	@Autowired
	private ServiceVehicleRepository repository;

	public List<ServiceVehicleDto> findAll() {
		List<ServiceVehicle> sVList = repository.findAll();
		List<ServiceVehicleDto> sVListDto = new ArrayList<>();
		for(ServiceVehicle item : sVList) {
			sVListDto.add(new ServiceVehicleDto().toDto(item));
		}
		return sVListDto;
	}

	/**
	 * get the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return ServiceVehicle
	 */
	public ServiceVehicleDto findById(int id) {
		ServiceVehicle sV = repository.findById(id);
		if(sV==null) {
			return null;
		}
		return new ServiceVehicleDto().toDto(sV);
	}

	/**
	 * Update the ServiceVehicle corresponding to the id given
	 * 
	 * @param id : Id given
	 */
	public boolean update(int id, ServiceVehicleDto object) {
		ServiceVehicle sVehicleDB = repository.findById(id);
		if (sVehicleDB == null) {
			return false;
		}
		sVehicleDB= object.toBean(object);
		repository.save(sVehicleDB);
		return true;
	}

	/**
	 * Create a ServiceVehicle
	 * 
	 * @param ServiceVehicle : the new ServiceVehicle
	 * @return boolean
	 */
	public boolean create(ServiceVehicleDto object) {
		ServiceVehicle sVehicleDB = repository.findByRegistration(object.getRegistration());
		if (sVehicleDB != null) {
			return false;
		}
		repository.save(object.toBean(object));
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
