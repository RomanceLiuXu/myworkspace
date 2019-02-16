package com.liuxu.normal;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
	//字符串的赋值与比较
    String a = "ab";
    String b = "ab";
    String c  = new String("ab");//c与 a b 的内存地址不一样
	//.equals比较的是值 ；==比较的是内存地址
	if (a.equals(c)) {
	System.out.println("数值相等");	
	}else
	System.out.println("数值不等");
	
	//字符串拼接  .concat
	String d = a.concat("cde");//由于String是不变字符串，拼接后会产生新的字符串
	
	//得到字符串的长度
	int le = d.length();
	
	//得到字符串中的某个字符,下标从0开始
	int i = d.charAt(1);
	
	//根据字符获取下标,没有的话会返回-1
	int index = d.indexOf("o");
	System.out.println(index);
	//也可以用于查找字符串，要把字符串看成一个整体,没有的话返回-1
	int index1 = d.indexOf("ae");
	System.out.println(index1);
	
	//获取字符串，左包含右不包含
	String substr = d.substring(1, 3);
	System.out.println(substr);
	
	//判断字符串的开头 .startsWith,返回布尔值
	
	//大小写转换   .toUpperCase 小写转大写            .toLowerCase  大写转小写
	
	//字符串切割
	String ss = "liuxu,lala,wuwu,huhu";
	   String[] names = ss.split(",");
	   System.out.println(Arrays.toString(names));
	
	//将字符串转为字符数组
	   String tt = "i am a good man";

	   char[] tochar = tt.toCharArray();
	   System.out.println(tochar);
	   //比较两个字符串，不区分大小写
	   String x = "ABCD";
	   String x1 = "abcd";
	   boolean r = x.equals(x1);
	   boolean re = x.equalsIgnoreCase(x1);
	   System.out.println(r);
	  
	
	
	
	}
	
}
