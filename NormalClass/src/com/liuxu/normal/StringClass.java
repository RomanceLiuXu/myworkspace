package com.liuxu.normal;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
	//�ַ����ĸ�ֵ��Ƚ�
    String a = "ab";
    String b = "ab";
    String c  = new String("ab");//c�� a b ���ڴ��ַ��һ��
	//.equals�Ƚϵ���ֵ ��==�Ƚϵ����ڴ��ַ
	if (a.equals(c)) {
	System.out.println("��ֵ���");	
	}else
	System.out.println("��ֵ����");
	
	//�ַ���ƴ��  .concat
	String d = a.concat("cde");//����String�ǲ����ַ�����ƴ�Ӻ������µ��ַ���
	
	//�õ��ַ����ĳ���
	int le = d.length();
	
	//�õ��ַ����е�ĳ���ַ�,�±��0��ʼ
	int i = d.charAt(1);
	
	//�����ַ���ȡ�±�,û�еĻ��᷵��-1
	int index = d.indexOf("o");
	System.out.println(index);
	//Ҳ�������ڲ����ַ�����Ҫ���ַ�������һ������,û�еĻ�����-1
	int index1 = d.indexOf("ae");
	System.out.println(index1);
	
	//��ȡ�ַ�����������Ҳ�����
	String substr = d.substring(1, 3);
	System.out.println(substr);
	
	//�ж��ַ����Ŀ�ͷ .startsWith,���ز���ֵ
	
	//��Сдת��   .toUpperCase Сдת��д            .toLowerCase  ��дתСд
	
	//�ַ����и�
	String ss = "liuxu,lala,wuwu,huhu";
	   String[] names = ss.split(",");
	   System.out.println(Arrays.toString(names));
	
	//���ַ���תΪ�ַ�����
	   String tt = "i am a good man";

	   char[] tochar = tt.toCharArray();
	   System.out.println(tochar);
	   //�Ƚ������ַ����������ִ�Сд
	   String x = "ABCD";
	   String x1 = "abcd";
	   boolean r = x.equals(x1);
	   boolean re = x.equalsIgnoreCase(x1);
	   System.out.println(r);
	  
	
	
	
	}
	
}
