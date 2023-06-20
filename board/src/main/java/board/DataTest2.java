package board;

import java.util.Arrays;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Obj {
	String str1="H";
	String str2="e";
	String str3="l";
	String str4="l";
	String str5="o";
}
	
public class DataTest2 {
	
	public static void main(String[] args) throws ParseException {
		//문자열
		String str = "Hello";
		//문자열 배열
//		String[] arr = {"H","e","l","l","o"};
		//객체
		Obj obj = new Obj();
//		System.out.println(str);
//		System.out.println(arr[0]);
//		System.out.println(obj.str1);
		//문자열 >> 배열
			String[] arrstr = str.split("");
			for (String s : arrstr) {
				System.out.println(s);
			}
		//배열 >> 문자열
		String[] arr = {"Hong","30"};
		String imsi1 = Arrays.toString(arr);
		String imsi2 = imsi1.substring(1,imsi1.length()-1);
		for (String s: imsi2.split(", ")) {
			System.out.println(s);
		}
		//indexOf, charAt, length
		
		//객체를 이용하여 JSON 생성
		JSONObject jobj = new JSONObject();
		jobj.put("one", 0);
		jobj.put("two", 0);
		jobj.put("three", 0);
		jobj.put("four", 0);
		System.out.println(jobj.toString());
		System.out.println(jobj.toJSONString());
		
		//문자열 형태의 JSON을 객체 형태로 변환
		String json = "{\"one\":0,\"two\":0,\"three\":0,\"four\":0}";
		JSONObject strJson = (JSONObject) new JSONParser().parse(json);
		System.out.println(strJson.get("one"));
		System.out.println(strJson.get("two"));
		System.out.println(strJson.get("three"));
		System.out.println(strJson.get("four"));
		
		//문제
		JSONObject forJson = new JSONObject();
		String[] key = {"one","two","three","four"};
		int[] value= {10,20,30,40};
		for(int i=0;i<key.length;i++) {
			forJson.put(key[i], value[i]);
		}
		System.out.println(forJson.toJSONString());

	}
}
