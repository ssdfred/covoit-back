package covoit.dtos;

import covoit.entities.Address;
import covoit.entities.Route;


public class RouteDto {
	
	protected double duration;
	protected double kmTotal;
	protected Address startAddress;
	protected Address endAddress;
	public RouteDto toDto(Route route) {
		RouteDto routeDto = new RouteDto();
		routeDto.setDuration(route.getDuration());
		routeDto.setKmTotal(route.getKmTotal());
		routeDto.setStartAddress(route.getStartAddress());
		routeDto.setEndAddress(route.getEndAddress());
		return routeDto;
	}
	public Route toBean(RouteDto routeDto) {
		Route route = new Route();
		route.setDuration(routeDto.getDuration());
		route.setKmTotal(routeDto.getKmTotal());
		route.setStartAddress(routeDto.getStartAddress());
		route.setEndAddress(routeDto.getEndAddress());
		return route;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getKmTotal() {
		return kmTotal;
	}
	public void setKmTotal(double kmTotal) {
		this.kmTotal = kmTotal;
	}
	public Address getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(Address startAddress) {
		this.startAddress = startAddress;
	}
	public Address getEndAddress() {
		return endAddress;
	}
	public void setEndAddress(Address endAddress) {
		this.endAddress = endAddress;
	}
}
