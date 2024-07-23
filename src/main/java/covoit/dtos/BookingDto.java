package covoit.dtos;

import java.time.LocalDateTime;

import covoit.entities.Booking;
import covoit.entities.ServiceVehicle;
import covoit.entities.UserAccount;

public class BookingDto {
	protected int id;
	protected LocalDateTime startDate;
	protected LocalDateTime endDate;
	protected ServiceVehicle serviceVehicle;
	protected UserAccount driver;

	public BookingDto toDto(Booking booking) {
		BookingDto bookingDto = new BookingDto();
		bookingDto.setId(booking.getId());
		bookingDto.setStartDate(booking.getStartDate());
		bookingDto.setEndDate(booking.getEndDate());
		bookingDto.setServiceVehicle(booking.getServiceVehicle());
		bookingDto.setDriver(booking.getDriver());
		return bookingDto;

	}

	public Booking toBean(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setStartDate(bookingDto.getStartDate());
		booking.setEndDate(bookingDto.getEndDate());
		booking.setServiceVehicle(bookingDto.getServiceVehicle());
		booking.setDriver(bookingDto.getDriver());
		return booking;
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
	 * Getter pour startDate
	 * 
	 * @return startDate
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * Setter pour startDate
	 * 
	 * @param startDate startDate
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * Getter pour endDate
	 * 
	 * @return endDate
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * Setter pour endDate
	 * 
	 * @param endDate endDate
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * Getter pour serviceVehicle
	 * 
	 * @return serviceVehicle
	 */
	public ServiceVehicle getServiceVehicle() {
		return serviceVehicle;
	}

	/**
	 * Setter pour serviceVehicle
	 * 
	 * @param serviceVehicle serviceVehicle
	 */
	public void setServiceVehicle(ServiceVehicle serviceVehicle) {
		this.serviceVehicle = serviceVehicle;
	}

	/**
	 * Getter pour driver
	 * 
	 * @return driver
	 */
	public UserAccount getDriver() {
		return driver;
	}

	/**
	 * Setter pour driver
	 * 
	 * @param driver driver
	 */
	public void setDriver(UserAccount driver) {
		this.driver = driver;
	}

}
