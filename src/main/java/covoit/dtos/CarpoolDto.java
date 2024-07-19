package covoit.dtos;

import java.time.LocalDate;
import java.util.List;

import covoit.entities.Carpool;
import covoit.entities.Route;
import covoit.entities.Vehicle;

public class CarpoolDto {
	private int id;
	private int availableSeat;
	private LocalDate startDate;
	private Vehicle vehicle;
	private Route route;
	private List<UserAccountDto> userAccounts;

	public CarpoolDto toDTO(Carpool object) {
		CarpoolDto carpoolDTO = new CarpoolDto();
		carpoolDTO.setStartDate(object.getStarDate());
		carpoolDTO.setRoute(object.getRoute());
		carpoolDTO.setVehicle(object.getVehicle());
		carpoolDTO.setAvailableSeat(object.getAvailableSeat());
		//TODO : See how contradiction between CarpoolDTO and Carpool should be handled
		//carpoolDTO.setUserAccounts(object.getUserAccounts());
		return carpoolDTO;
	}

	public Carpool toBean(CarpoolDto object) {
		Carpool carpool = new Carpool();
		carpool.setStarDate(object.getStartDate());
		carpool.setRoute(object.getRoute());
		carpool.setVehicle(object.getVehicle());
		carpool.setAvailableSeat(object.getAvailableSeat());
		
		return carpool;
		//TODO : See how contradiction between CarpoolDTO and Carpool should be handled
		//carpool.setUserAccounts(object.getUserAccounts());		return null;
	}

	// Getters and setters
	public int getId() {
		return id;

	}

	public void setId(int i) {
		this.id = i;
	}

	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<UserAccountDto> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<UserAccountDto> userAccounts) {
		this.userAccounts = userAccounts;
	}

}