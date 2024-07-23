package covoit.dtos;

import covoit.entities.Brand;
import covoit.entities.Category;
import covoit.entities.Vehicle;
import covoit.entities.VehicleModel;

public class VehicleDto {
	private int id;
	private String registration;
	private int nbSeat;
	private Brand brand;
	private VehicleModel model;
	private Category category;
	
	public VehicleDto toDto(Vehicle vh) {
		VehicleDto vhDto = new VehicleDto();
		vhDto.setId(vh.getId());
		vhDto.setRegistration(vh.getRegistration());
		vhDto.setNbSeat(vh.getNbSeat());
		vhDto.setBrand(vh.getBrand());
		vhDto.setModel(vh.getModel());
		vhDto.setCategory(vh.getCategory());
		return vhDto;
	}
	public Vehicle toBean(VehicleDto vhDto) {
		Vehicle vh = new Vehicle();
		vh.setRegistration(vhDto.getRegistration());
		vh.setNbSeat(vhDto.getNbSeat());
		vh.setBrand(vhDto.getBrand());
		vh.setModel(vhDto.getModel());
		vh.setCategory(vhDto.getCategory());
		return vh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public int getNbSeat() {
		return nbSeat;
	}

	public void setNbSeat(int nbSeat) {
		this.nbSeat = nbSeat;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public VehicleModel getModel() {
		return model;
	}

	public void setModel(VehicleModel model) {
		this.model = model;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
