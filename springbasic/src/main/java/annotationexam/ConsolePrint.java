package annotationexam;

public class ConsolePrint implements Print{

    @Override
    public void print(String name, int kor, int eng, int math) {
        System.out.println("이름: "+name);
        System.out.println("국어: "+kor);
        System.out.println("영어: "+eng);
        System.out.println("수학: "+math);
    }
}
