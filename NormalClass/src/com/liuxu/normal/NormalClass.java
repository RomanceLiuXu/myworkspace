package com.liuxu.normal;

import java.util.Arrays;
import java.util.Scanner;

public class NormalClass {

	public static void main(String[] args) {
		 //Arrays��
	
		//Math��
//	double a = Math.random();//[0,1)
//	System.out.println(a);
//	int[] randomArr = new int[10];
//	for (int i = 0; i < 10; i++) {
//	int randomNum =(int)( Math.random()*13 + 10);//[10,23)	
//	randomArr[i] = randomNum;
//	}
//	System.out.println("ʮ�������Ϊ��"+Arrays.toString(randomArr));
	
	//�ӿ���̨�����ַ�����Ҫ�󳤶ȴ���6���������в���������
	Scanner scanner = new Scanner(System.in);
	System.out.println("������һ���ַ�����");
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
	 
			
		}System.out.println("���벻��ȷ");
	
	}else
	System.out.println("���벻��ȷ");
	}
    }


