package ex230322;

public class Login {
	private String id;
	private String password;
	//������ �Լ�
	public Login() { }
	public Login(String id, String password) {
		this.id=id;
		this.password=password;
	}
	//�Ӽ��� ���� �Է�, ����ϴ� �Լ�
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
	//��ü �Ӽ��� ����ϴ� �Լ�
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
