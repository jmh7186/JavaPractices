package ex230327;

public class SungjukUse {
	 public static void main(String[] args) {
	        SungjukMgr mgr = new SungjukMgr();
	        
	        Sungjuk sungjuk = new Sungjuk();
	        sungjuk.name="hong";
	        sungjuk.kuk=100;
	        sungjuk.eng=90;
	        sungjuk.kuk=80;
	        //mgr.setValue("hong", 100, 90, 80);
	        mgr.setValue(sungjuk); // �� �ʱ�ȭ
	        mgr.calcTot(sungjuk);  // ���� ���
	        mgr.calcAvg(sungjuk);  // ���
	        mgr.print(sungjuk);
	        
	    }
}
