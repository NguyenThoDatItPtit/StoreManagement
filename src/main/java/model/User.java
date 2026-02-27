package model;

public class User {

	private int id;
	private String username, password, email, phone;

	public User() {
	}

	public User(String u, String p, String e, String ph) {
		username = u;
		password = p;
		email = e;
		phone = ph;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
}