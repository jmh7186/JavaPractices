package gameboard;

public class GBMemberVO {
	private String id;
	private String pwd;
	private String hp;
	private String email;

	public GBMemberVO() {
		// TODO Auto-generated constructor stub
	}

	public GBMemberVO(String id, String pwd, String hp, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.hp = hp;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GBMemberVO [id=" + id + ", pwd=" + pwd + ", hp=" + hp + ", email=" + email + "]";
	}

}
