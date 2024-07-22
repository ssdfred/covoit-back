package covoit.dtos;

import java.time.LocalDateTime;

import covoit.entities.Booking;
import covoit.entities.ServiceVehicle;
import covoit.entities.UserAccount;

public class BookingDto {
	protected LocalDateTime startDate;
	protected LocalDateTime endDate;
	protected ServiceVehicle serviceVehicle;
	protected UserAccount driver;
	
	
	public BookingDto toDto(Booking booking) {
		BookingDto bookingDto = new BookingDto();
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
	
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public ServiceVehicle getServiceVehicle() {
		return serviceVehicle;
	}
	public void setServiceVehicle(ServiceVehicle serviceVehicle) {
		this.serviceVehicle = serviceVehicle;
	}
	public UserAccount getDriver() {
		return driver;
	}
	public void setDriver(UserAccount driver) {
		this.driver = driver;
	}
}
