package covoit.dtos;

import java.util.HashSet;
import java.util.Set;

import covoit.entities.Address;
import covoit.entities.Route;

public class AddressDto {
	protected int id;
	protected String detail;
	protected String city;
	protected String country;
	private Set<Route> routes = new HashSet<>();
	
	public AddressDto toDTO(Address object){
		AddressDto addressDTO = new AddressDto();
		addressDTO.setCity(object.getCity());
		addressDTO.setCountry(object.getCountry());
		addressDTO.setDetail(object.getDetail());
		addressDTO.setRoutes(object.getRoutes());
		return addressDTO;
	}
	
	public Address toBean(AddressDto object) {
		Address address = new Address();
		address.setCity(object.getCity());
		address.setCountry(object.getCountry());
		address.setDetail(object.getDetail());
		address.setRoutes(object.getRoutes());
		return address;
	}
	
	/** Getter pour detail
	 * @return detail
	 */
	public String getDetail() {
		return detail;
	}
	/**Setter pour detail
	 * @param detail detail 
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/** Getter pour city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**Setter pour city
	 * @param city city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/** Getter pour country
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	/**Setter pour country
	 * @param country country 
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/** Getter pour routes
	 * @return routes
	 */
	public Set<Route> getRoutes() {
		return routes;
	}
	/**Setter pour routes
	 * @param routes routes 
	 */
	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	/** Getter pour id
	 * @return id
	 */
	public int getId() {
		return id;
	}
}
