package com.liuxu.normal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class NormalClassWork {

	public static void main(String[] args) throws ParseException {
//		//获取系统当前时间，要求打印格式为xxxx年xx月xx日 xx时xx分xx秒 星期x
//
//		Date date = new Date();
//		//格式化时间
//		SimpleDateFormat format  = new SimpleDateFormat("yyyy年MM月dd日 E");
//		String now = format.format(date);
//		System.out.println("当前时间："+now);
		
		
//		//给定字符串 "1989-09-10 23:15:36" 转换为Date类型 并获取其中的分钟和时间戳
//        
//	    String date1 = "1989-09-10 23:15:36";
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
//	    //将字符串转换为Date类型
//        Date dateNew = ft.parse(date1);
//	    int dMinute = dateNew.getMinutes();//获取分钟
//	    //时间戳
//	    long dateStamp = dateNew.getTime();
//	    System.out.println(dateNew);
//	    System.out.println(dMinute);
//	    System.out.println(dateStamp);
		
		
		//通过Number的子类得到所有整数型和浮点型的最大表数、最小表数、字节数
	    /*
	     * Number子类：Interger Byte Double Float  Char Long
	     * 
	     */
        
		
	    //日期类Calendar
		Calendar calendar = Calendar.getInstance();
//		Date date = calendar.getTime();
//		calendar.setTime(date);
//		calendar.setTime(new Date());
//		System.out.println("今天日期："+calendar.get(Calendar.DAY_OF_MONTH));
	   
		Random r = new Random();
	    int random  = r.nextInt(2);
	    System.out.println(random);
	}

}
