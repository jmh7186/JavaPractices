package annotationexam;

public class GridPrint implements Print{

    @Override
    public void print(String name, int kor, int eng, int math) {
        System.out.println("-----------------------------------");
        System.out.println("|   이름   |  국어  |  영어  |  수학  |");
        System.out.println("|  "+name+"  |  "+kor+"   |  "+eng+"  |   "+math+"  |");
        System.out.println("-----------------------------------");
    }
}
