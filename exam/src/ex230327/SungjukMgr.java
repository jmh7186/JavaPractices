package ex230327;

public class SungjukMgr {
	    Sungjuk sungjuk;
	    // �� �� �ʱ�ȭ
	    public void setValue(Sungjuk sungjuk){
	       this.sungjuk=sungjuk;
	    }
	   
	    // �� ����
	    public void calcTot(Sungjuk sungjuk){
	    	setValue(sungjuk);
	    	this.sungjuk.tot=sungjuk.kuk+sungjuk.eng+sungjuk.math;
	    }
	   
	    // �� ���    
	    public void calcAvg(Sungjuk sungjuk){
	    	setValue(sungjuk);
	       this.sungjuk.avg=sungjuk.kuk+sungjuk.eng+sungjuk.math/3;
	    }
	   
	    // �� ���    
	    public void print(Sungjuk sungjuk){
	       
	    }

}
