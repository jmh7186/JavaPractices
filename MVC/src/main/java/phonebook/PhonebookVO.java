package phonebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhonebookVO {
	private String idx;
	private String name;
	private String hp;
	private String company;
	private String email;
	private String birthday;
	private String address;
	private String memo;

	public PhonebookVO() {
	}

	public PhonebookVO(String idx, String name, String hp, String company, String email, String address,
			String birthday, String memo) {
		this.idx = idx;
		this.name = name;
		this.hp = hp;
		this.company = company;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
		this.memo = memo;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		if (company == null || company.equals(""))
			return "-";
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		if (email == null || email.equals(""))
			return "-";
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		try {
			if (birthday != null && !(birthday.equals(""))) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date _birthday;
				_birthday = formatter.parse(birthday);
				birthday = formatter.format(_birthday);
				return birthday;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return "ERROR";
		}
		return "-";
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		if (address == null || address.equals(""))
			return "-";
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		if (memo == null || memo.equals(""))
			return "-";
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "PhonebookVO [idx=" + idx + ", name=" + name + ", hp=" + hp + ", company=" + company + ", email=" + email
				+ ", birthday=" + birthday + ", address=" + address + ", memo=" + memo + "]";
	}
}
