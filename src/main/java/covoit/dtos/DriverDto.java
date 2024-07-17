package covoit.dtos;

import covoit.entities.Driver;
import covoit.entities.Vehicle;

public class DriverDto {
	private String name;
	private String lastname;
	private Vehicle vehicle;
	private boolean driverLicence;
	
	public DriverDto toDto(Driver driver) {
		DriverDto driverDto = new DriverDto();
		driverDto.setLastname(driver.getLastName());
		driverDto.setName(driver.getName());
		driverDto.setDriverLicence(driver.isDriverLicence());
		driverDto.setVehicle(driver.getVehicles().stream().findFirst().get());
		return driverDto;
	}
	public Driver toBean(DriverDto driverDto) {
		//TODO password a check
		Driver driver = new Driver(driverDto.getName(), driverDto.getLastname(), driverDto.getDriverLicence(), null);
		return driver;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean getDriverLicence() {
		return driverLicence;
	}
	public void setDriverLicence(boolean b) {
		this.driverLicence = b;
	}
}
