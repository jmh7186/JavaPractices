package ex230331;
//자동차의 기능은 다음과 같습니다.(모두 void형으로 선언)
//1) 핸든조작(movehandle)
//2) 엑셀레이터조작(controllerAcc)
//3) 브레이크조작(controllerBreak)
//4) 창문조작(controllerWindow)
//다음 기능을 설계하는 자바 파일을 만드세요.

public interface CarInter {
public void movehandle();
public void controllerAcc();
public void controllerBreak();
public void controllerWindow();
}
