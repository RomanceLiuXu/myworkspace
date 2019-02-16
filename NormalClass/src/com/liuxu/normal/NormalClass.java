package com.liuxu.normal;

import java.util.Arrays;
import java.util.Scanner;

public class NormalClass {

	public static void main(String[] args) {
		 //Arrays类
	
		//Math类
//	double a = Math.random();//[0,1)
//	System.out.println(a);
//	int[] randomArr = new int[10];
//	for (int i = 0; i < 10; i++) {
//	int randomNum =(int)( Math.random()*13 + 10);//[10,23)	
//	randomArr[i] = randomNum;
//	}
//	System.out.println("十个随机数为："+Arrays.toString(randomArr));
	
	//从控制台输入字符串，要求长度大于6，并且其中不能有数字
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入一个字符串：");
	String str = scanner.nextLine();
	if ((str.length() > 0 && str.length() <= 6) ) {
	 for(int i = 0; i < str.length();i++) {
		char[] ch = str.toCharArray();
	    char c = ch[i];
	 //for(int j = 0;j <= str.length();j++){
	 if(c >= 48 && c <= 57) {
		
	//}
	 break;
	 }
	 
			
		}System.out.println("输入不正确");
	
	}else
	System.out.println("输入不正确");
	}
    }


