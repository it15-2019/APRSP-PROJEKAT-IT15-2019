package usersservice;

public class CreateUserDto {

	private String email;
	private String password;

	public CreateUserDto() {

    }

	public CreateUserDto(String email, String password) {
	
		this.email = email;
		this.password = password;
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
}

