package covoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.dtos.VehicleModelDto;
import covoit.entities.VehicleModel;
import covoit.repository.VehicleModelRepository;

@Service
public class VehicleModelService {
	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	public List<VehicleModelDto> findAll() {
		List<VehicleModel> vehicleModels = vehicleModelRepository.findAll();
		List<VehicleModelDto> vehivleModelsDto = new ArrayList<>();
		for(VehicleModel vm : vehicleModels){
			vehivleModelsDto.add(new VehicleModelDto().toDto(vm));
		}
		return vehivleModelsDto;
	}

	/**
	 * get the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return VehicleModel
	 */
	public VehicleModelDto findById(int id) {
		VehicleModel vm = vehicleModelRepository.findById(id);
		if(vm == null) {
			return null;
		}
		
		return new VehicleModelDto().toDto(vm);
	}

	/**
	 * Update the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean update(int id, VehicleModelDto object) {
		VehicleModel modelDB = vehicleModelRepository.findById(id);
		if (modelDB == null) {
			return false;
		}
		modelDB = object.toBean(object);
		vehicleModelRepository.save(modelDB);
		return true;
	}

	/**
	 * Create an VehicleModel
	 * 
	 * @param VehicleModel : the new VehicleModel
	 * @return A confirmation message
	 */
	public boolean create(VehicleModelDto object) {
		VehicleModel modelDB = vehicleModelRepository.findByName(object.getName());
		if (modelDB != null) {
			return false;
		}
		vehicleModelRepository.save(object.toBean(object));
		return true;
	}

	/**
	 * Delete the VehicleModel corresponding to the id given
	 * 
	 * @param id : Id given
	 * @return A confirmation message
	 */
	public boolean delete(int id) {
		VehicleModelDto modelDB = findById(id);
		if (modelDB == null) {
			return false;
		}

		vehicleModelRepository.deleteById(id);
		return true;
	}
}
