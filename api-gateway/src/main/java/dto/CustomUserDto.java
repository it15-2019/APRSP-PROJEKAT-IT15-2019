package dto;

public class CustomUserDto {

	private String email;
	private String password;
	private String role;

	public CustomUserDto() {

    }

	public CustomUserDto (String email, String password, String role) {
	
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	//GET I SET METODE

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
