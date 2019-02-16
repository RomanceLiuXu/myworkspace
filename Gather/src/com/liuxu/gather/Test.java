package com.liuxu.gather;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
//		String string = "nihao";
//		String string2 = new String("nihao");
//		String string3 = "nihao";
//		Scanner scanner = new Scanner(System.in);
//		String  string4 = scanner.next();
//		boolean s = string == string4;
//		System.out.println(s);
//		boolean sw = string.equals("nihao");
//		System.out.println(s);		
//		System.out.println(sw);
//		Integer a = 1;
//		Integer b = 1;
//		boolean d = a==b;
//		System.out.println(d);
//		
//		String str = "name=zhangsan age=18 classNo=090728";
//		//分割
//		String[] a = str.split(" ");
//		for (String string : a) {
//			string =string.substring(string.indexOf("=")+1);
//			System.out.print(string + " ");
//		}
		Set<String> set = new TreeSet<>();
		set.add("aa");
		int a  = set.hashCode();
		System.out.println(a);
	}
	public void name() {


}
}