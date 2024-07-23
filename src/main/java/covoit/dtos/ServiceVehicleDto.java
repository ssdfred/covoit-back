package covoit.dtos;

import java.util.Set;

import covoit.entities.Booking;
import covoit.entities.ServiceVehicle;

public class ServiceVehicleDto {
	protected int id;
	protected String registration;
	protected String state;
	protected String picture;
	protected String motorization;
	protected double co2Km;
	private Set<Booking> bookings;

	public ServiceVehicleDto toDto(ServiceVehicle sV) {
		ServiceVehicleDto sVDto = new ServiceVehicleDto();
		sVDto.setId(sV.getId());
		sVDto.setRegistration(sV.getRegistration());
		sVDto.setState(sV.getState());
		sVDto.setPicture(sV.getPicture());
		sVDto.setMotorization(sV.getMotorization());
		sVDto.setCo2Km(sV.getCo2Km());
		sVDto.setBookings(sV.getBookings());
		return sVDto;
	}

	public ServiceVehicle toBean(ServiceVehicleDto vhDto) {
		ServiceVehicle sV = new ServiceVehicle();
		sV.setRegistration(vhDto.getRegistration());
		sV.setState(vhDto.getState());
		sV.setPicture(vhDto.getPicture());
		sV.setMotorization(vhDto.getMotorization());
		sV.setCo2Km(vhDto.getCo2Km());
		sV.setBookings(vhDto.getBookings());
		return sV;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMotorization() {
		return motorization;
	}

	public void setMotorization(String motorization) {
		this.motorization = motorization;
	}

	public double getCo2Km() {
		return co2Km;
	}

	public void setCo2Km(double co2Km) {
		this.co2Km = co2Km;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
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

	/**
	 * Getter pour registration
	 * 
	 * @return registration
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * Setter pour registration
	 * 
	 * @param registration registration
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

}
