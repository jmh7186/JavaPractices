package ex230327;

public class SungjukMgr {
	    Sungjuk sungjuk;
	    // ⓐ 값 초기화
	    public void setValue(Sungjuk sungjuk){
	       this.sungjuk=sungjuk;
	    }
	   
	    // ⓑ 총점
	    public void calcTot(Sungjuk sungjuk){
	    	setValue(sungjuk);
	    	this.sungjuk.tot=sungjuk.kuk+sungjuk.eng+sungjuk.math;
	    }
	   
	    // ⓒ 평균    
	    public void calcAvg(Sungjuk sungjuk){
	    	setValue(sungjuk);
	       this.sungjuk.avg=sungjuk.kuk+sungjuk.eng+sungjuk.math/3;
	    }
	   
	    // ⓓ 출력    
	    public void print(Sungjuk sungjuk){
	       
	    }

}
