package ex230517;

//create table phonebook(
//id number(4) primary key,
//name varchar2(50) not null,
//tel char(13) not null,
//memo varchar2(200)
//);

public class PhonebookVO {
	private int id;
	private String name;
	private String tel;
	private String memo;
	
	//기본생성자, 필드생성자, get/set 함수, toString 함수
	public PhonebookVO() {
		// TODO Auto-generated constructor stub
	}

	public PhonebookVO(int id, String name, String tel, String memo) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.memo = memo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "PhonebookVO [id=" + id + ", name=" + name + ", tel=" + tel + ", memo=" + memo + "]";
	}
	
}
