package ex230414;

import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) {
		//문자열 처리하기
		String s="hello java";
		char c=s.charAt(0);
		char c1="hello java".charAt(0);
		System.out.println(c);
		System.out.println(c1);
		System.out.println(s.charAt(0));
		
		//문자는 완성된 문자에서 일부를 가지오는 함수(일부추출)
		//charAt : 위치번호를 적으면 한문자를 추출하는 함수
		//성별에 관련된 데이터를 추출하세요? 추출한 데이터를 이용하여 남자, 여자로 표시하세요.
		System.out.println("820305-2234567".charAt(7));
		char gen="820305-2234567".charAt(7);
		if(gen=='1') System.out.println("남자");
		else System.out.println("여자");
		
		String jumin="820305-2234567";
		gen=jumin.charAt(7);
		if(gen=='1') System.out.println("남자");
		else System.out.println("여자");
		
		//substring : 문자열의 일부를 추출하는 함수
		//(*문자열 위치는 0부터시작, 뒤에 인덱스는 번호 전까지 출력이 됨)
		System.out.println(jumin.substring(0));
		System.out.println(jumin.substring(0,2));
		System.out.println(jumin.substring(2,4));
		
		//일부의 문자를 합쳐서 완성된 문자로 만드는 함수(문자열합치기)
		//concat:문자열을 합하는 명령
		System.out.println("java".concat("hello"));
		//주민등록번호에서 년을 추출하여 1982로 만드세요.?
		jumin="820305-2234567";		
		System.out.println("19".concat(jumin.substring(0,2)));
		//1982년03월05일로 문자열을 만드세요
		"19".concat(jumin.substring(0,2));
		jumin.substring(2,4);
		jumin.substring(4,6);
		
		int f=0, t=2;
		for(int i=0;i<3;i++) {
			System.out.println(jumin.substring(f,t));
			f=f+2;
			t=t+2;
		}
		
		for(int i=0;i<=4;i=i+2) {
			System.out.println(jumin.substring(i,i+2));
		}
		
		for(int i=0;i<3;i++) {
			System.out.println(jumin.substring(2*i,2*i+2));
		}
		//문자열의 길이 확인
		jumin="820305-2234567";
		System.out.println(jumin.length());
		
		//위치를 찾아주는 함수
		String filename="aaaaa.html";
		System.out.println(filename.indexOf('.'));
		//위의 파일을 index와 html로 분리하시오.
		System.out.println(filename.substring(0,filename.indexOf('.')));
		System.out.println(filename.substring(filename.indexOf('.')+1,filename.length()));
		//split :문자열 분리
		String[] imsi=filename.split("\\."); //* 정규식은 \\를 포함하여 구성되며 특수문자에 적용
		System.out.println(imsi[0]);
		System.out.println(imsi[1]);
		
		//값을 변경하는 함수
		System.out.println("hello java".replace(' ',':'));
		System.out.println("hello java 100~200".replace(' ',':'));
		System.out.println("hello java".replace("java","html"));
		
		//lastindexof
		String content="seoulseoulseoul";
		System.out.println(content.indexOf("seoul"));
		System.out.println(content.indexOf("seoul", 5));//5번째부터 seoul을 찾아라
		System.out.println(content.indexOf("seoul", content.indexOf(' ')));
		System.out.println(content.lastIndexOf("seoul"));
		
		//content에 있는 seoul의 단어가 몇번 나오는지 분석하시오.
		//힌트:문장의 전체 길이를 확인하고 반복문을 돌린다.
		//반복문을 실행하기전 현재 글 검색의 위치(포인터)는 0으로 시작한다.
		//count알고리즘을 적용
		content="seoulaaaa seoul seoulbbb seoul ";
		System.out.println(content.indexOf("seoul ",20));
		//검색하는 값이 존재하지 않을 경우 -1이 결과로 출력
		
		String search="seoul ";
		int result=-1;
		int count=0;
		for(int point=0;point<content.length();) {
			result=content.indexOf(search,point);
			if(result>-1) {
				System.out.println("결과:"+result);
				//찾았다.
				count++;
				point=point+search.length();
			}else {
				count--;
				break;
			}
		}
		System.out.println("검색횟수:"+count);
		
		//contains: 포함되다(결과 true, false)
		content="i live seoul";
		System.out.println(content.contains("seoul"));
		if(content.contains("pusan")) {
			System.out.println("검색글자가 포함되어 있습니다.");
		}else {
			System.out.println("검색글자가 없습니다.");
		}
		
		//공백제거
		System.out.println("     hello      ".trim());
		
		//대소문자처리
		content="i live seoul";
		System.out.println(content.toUpperCase());
		System.out.println(content.toUpperCase().toLowerCase());
		
		for(String ss:content.split(" ")) {
			System.out.println(ss);
		}
		
		//어떤 문장에서 해당하는 글자의 카운터를 측정합니다.
		content="i live seoul. Are you in seoul";
		//seoul이라는 단어가 몇번 나타나는가?
		count=0;
		for(String ss:content.split(" ")) {
			//if(ss.equals("seoul")) count++; //문자열이 완전히 일치하는 경우
			if(ss.contains("seoul")) count++; //문자열이 포함된 경우
		}
		System.out.println(count);
		
		
		//문자열 비교와 객체비교
		String insa="hello";
		System.out.println(insa.equals("hello"));
		System.out.println("hello".equals(insa));
		if(insa.equals("hello")) {
			System.out.println("일치");
		}else {
			System.out.println("불일치");
		}
		
		System.out.println(insa=="hello");
		
		Test t1=new Test();
		Test t2=new Test();
		System.out.println(t1==t2); //두 객체는 동일하지 않다.
		Test t3=t1;
		System.out.println(t1==t3); //동일한 객체를 가르키고 있음
		//* 유의사항 == 일반변수에는 값이 같다라고 표현되지만
		// 객체에서는 동일한 객체를 가르키고 있는지 확인하는 연산자이다.
		
		//compareTo : 아스키코드값 비교
		System.out.println((byte)'a'); //아스키코드 97
		System.out.println((byte)'c'); //아스키코드 99
		System.out.println("a".compareTo("d")); //두 아스키코드를 비교하여 차이값 출력
		//System.out.println("hello".compareTo("o")); //문자열비교가 아님
		
		//StringTokenizer : 토큰
		StringTokenizer token=new StringTokenizer("010-1111-2222");
		System.out.println(token.nextToken("-")); //-를 찾는다(흐름)
		System.out.println(token.nextToken("-"));
		System.out.println(token.nextToken("-"));
		
		
		
		
	}

}
