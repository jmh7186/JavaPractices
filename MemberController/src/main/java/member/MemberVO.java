package member;

public class MemberVO {
	private String id;
	private String pwd;
	private String hp;
	private String adr;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String pwd, String hp, String adr) {
		this.id = id;
		this.pwd = pwd;
		this.hp = hp;
		this.adr = adr;
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

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", hp=" + hp + ", adr=" + adr + "]";
	}
	
	
}
