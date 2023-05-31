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
	        mgr.setValue(sungjuk); // °ª ÃÊ±âÈ­
	        mgr.calcTot(sungjuk);  // ÃÑÁ¡ °è»ê
	        mgr.calcAvg(sungjuk);  // Æò±Õ
	        mgr.print(sungjuk);
	        
	    }
}
