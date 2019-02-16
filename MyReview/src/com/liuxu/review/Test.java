package com.liuxu.review;

import java.util.ArrayList;
import java.util.List;

public class Test {

	
	public static void main(String[] args) {
		
		Child parent = new Child();
		System.out.println(parent instanceof Child);
		List<String> list = new ArrayList<>();
//		list.removeAll(c);
//		int[] a = {1,2,3,4,5};
//		int[] b = change(a);
//		b[1] = 7;
//		System.out.println(a+":"+b);
//		System.out.println(a[1]);
		
		System.out.println(aString(""));
		
	}
	
	public static String aString(String str){
		try {
			str+="a";
			return str;
		} catch (Exception e) {
			str+="b";
			return str;
		}finally{
			str+="c";
			return str;
		}
	}
	public static int[] change(int[] a ){
		a[1]=6;
		return a;
	}
	
}
class Parent{
	int i = 2;
	M m = new M();
	static{
		System.out.println("父类的静态代码块");
	}
	public Parent(){
		System.out.println("parent");
	} 
}

class Child extends Parent{
	int i = 5;
	N n = new N();
	static{
		System.out.println("子类的静态代码块");
	}
	public Child(){
		System.out.println("child");
	}
}

class M{
	public M(){
		System.out.println("M");
	}
}

class N{
	public N(){
		System.out.println("N");
	}
}
