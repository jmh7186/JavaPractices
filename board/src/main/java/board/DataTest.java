package board;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataTest {
	
	public static void main(String[] args) {
		int[] intarr1 = {10,20,30,40,50};
		int[] intarr2 = new int[100];
		intarr2[0]=100;
		intarr2[1]=200;
		intarr2[3]=400;
		//기존 배열의 문제점: 크기를 관리해주어야 하며 중간에 빈 값도 따로 신경써야 한다.
		//배열의 문제점을 보완한 자료구조 : set, list, map
		Set<String> set = new HashSet<String>();
		HashSet<String> hset = new HashSet<String>(); //인터페이스를 활용
		
		set.add("Apple");
		set.add("Mango");
		set.add("Banana");
		System.out.println(set.toString());
		
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		set.remove("Mango");
		
		for(String s: set) {
			System.out.println(s);
		}
		
		
	}
}
