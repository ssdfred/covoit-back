package covoit.dtos;

import java.util.HashSet;
import java.util.Set;

import covoit.entities.Brand;
import covoit.entities.Vehicle;

public class BrandDto {
	protected int id;
	protected String name;
	private Set<Vehicle> vehicles = new HashSet<>();

	public BrandDto toDto(Brand brand) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId(brand.getId());
		brandDto.setName(brand.getName());
		;
		brandDto.setVehicles(brand.getVehicles());

		return brandDto;
	}

	public Brand toBean(BrandDto brandDto) {
		Brand brand = new Brand();
		brand.setName(brandDto.getName());
		brand.setVehicles(brandDto.getVehicles());
		return brand;
	}

	/**
	 * Getter pour name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter pour name
	 * 
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter pour vehicles
	 * 
	 * @return vehicles
	 */
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * Setter pour vehicles
	 * 
	 * @param vehicles vehicles
	 */
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * Getter pour id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id
	 * 
	 * @param id id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
