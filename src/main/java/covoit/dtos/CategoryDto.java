package covoit.dtos;

import java.util.HashSet;
import java.util.Set;

import covoit.entities.Category;
import covoit.entities.Vehicle;

public class CategoryDto {
	protected String name;
	private Set<Vehicle> vehicles = new HashSet<>();
	
	public CategoryDto toDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName(category.getName());
		categoryDto.setVehicles(category.getVehicles());
		return categoryDto;
	}
	
	public Category toBean(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setVehicles(categoryDto.getVehicles());
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
