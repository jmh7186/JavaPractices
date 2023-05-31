package ex230419;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main5 {

	public static void main(String[] args) throws IOException {
		//파일객체를 생성하고 파일의 정보 중 길이로 확인하는 방법
		File file=new File("index.html");
		System.out.println(file.length());
		
		
		//파일 사이즈를 이름(문자열)으로 확인하는 방법
		Path path=Paths.get("index.html");
		System.out.println(Files.size(path));
		
		//스트림안에 들어 있는 파일의 크기를 확인하므로
		//용량이 큰 파일인 경우 buf의 최대값이 있으므로
		//buf의 최대값이 크기로 출력이 됨.
		FileInputStream in=new FileInputStream(file);
		System.out.println(in.available());

	}

}
