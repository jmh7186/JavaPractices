package ex230424;

public class Main4 {

	public static void main(String[] args) {
		NewProtocol p=new NewProtocol();
		
		p.packet=new byte[20];
		
		System.arraycopy
		("admin".getBytes(),0, p.packet, 0, "admin".length());
		
		System.arraycopy
		("1234".getBytes(),0, p.packet, 10, "1234".length());
		
		System.out.println(p.getId());
		System.out.println(p.getPassword());
		
		

	}

}
