package user;

public class User {
	
	private int    no;
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;
	
	public User() {
		super();
	}
	public User(String id, String password, String name, String gender, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}
	public int getNo() {
		return no;
	}
	public User setNo(int no) {
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		return this;
	}
	public String getId() {
		return id;
	}
	public User setId(String id) {
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		return this;
	}
	public String getGender() {
		return gender;
	}
	public User setGender(String gender) {
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		return this;
	}
	
	
	
}



	