package ex230322;

public class Login {
	private String id;
	private String password;
	//생성자 함수
	public Login() { }
	public Login(String id, String password) {
		this.id=id;
		this.password=password;
	}
	//속성의 값을 입력, 출력하는 함수
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	//전체 속성을 출력하는 함수
	@Override
	public String toString() {
		return "id:"+id+",password:"+password;
	}
	
	public boolean loginAccess(String id,String password) {
		if(this.id.equals(id) && this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
		
}
