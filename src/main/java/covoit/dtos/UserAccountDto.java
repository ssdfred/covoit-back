package covoit.dtos;

public class UserAccountDto {

	private Long id;
	private String name;
	private String lastName;
	private boolean permis;
	private String password;
	@Override
	public String toString() {
		return "UserAccountDto [name=" + name + ", lastName=" + lastName + ", permis=" + permis + ", password="
				+ password + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isPermis() {
		return permis;
	}
	public void setPermis(boolean permis) {
		this.permis = permis;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
