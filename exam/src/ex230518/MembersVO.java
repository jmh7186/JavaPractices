package ex230518;

public class MembersVO {
	private String id;
	private String password;
	private String tel;
	private String rrn;
	private String address;
	private String email;
	private String username;
	
	public MembersVO() {
		// TODO Auto-generated constructor stub
	}

	public MembersVO(String id, String password, String tel, String rrn, String address, String email,
			String username) {
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.rrn = rrn;
		this.address = address;
		this.email = email;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "MembersVO [id=" + id + ", password=" + password + ", tel=" + tel + ", rrn=" + rrn + ", address="
				+ address + ", email=" + email + ", username=" + username + "]";
	}
	
}
