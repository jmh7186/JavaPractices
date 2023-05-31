
public class Sungjuk {
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Sungjuk() {
		// TODO Auto-generated constructor stub
	}
		
	public Sungjuk(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Sungjuk(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	//�л�����, ����
	//�Է�
	public void infoInsert(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void scoreInsert(int kor, int math, int eng) {
		this.kor=kor;
		this.math=math;
		this.eng=eng;
	}
	//���(��ü ���)
	public void infoSelect() {
		System.out.println("�й�:"+id);
		System.out.println("�̸�:"+name);
	}
	
	public void scoreSelect() {
		System.out.println("����:"+kor);
		System.out.println("����"+eng);
		System.out.println("����"+math);
	}
	//����
	public void infoUpdate(String name) {
		this.name=name;
	}
	public void scoreUpdate(int kor, int eng, int math) {
		this.kor=kor;
		this.math=math;
		this.eng=eng;
	}
	//����
	public void infoDelete() {
		this.id="";
		this.name="";
	}
	public void scoreDelete() {
		this.kor=0;
		this.math=0;
		this.eng=0;
	}

	@Override
	public String toString() {
		return "Sungjuk [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
}
