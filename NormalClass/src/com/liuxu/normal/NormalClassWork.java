package com.liuxu.normal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class NormalClassWork {

	public static void main(String[] args) throws ParseException {
//		//��ȡϵͳ��ǰʱ�䣬Ҫ���ӡ��ʽΪxxxx��xx��xx�� xxʱxx��xx�� ����x
//
//		Date date = new Date();
//		//��ʽ��ʱ��
//		SimpleDateFormat format  = new SimpleDateFormat("yyyy��MM��dd�� E");
//		String now = format.format(date);
//		System.out.println("��ǰʱ�䣺"+now);
		
		
//		//�����ַ��� "1989-09-10 23:15:36" ת��ΪDate���� ����ȡ���еķ��Ӻ�ʱ���
//        
//	    String date1 = "1989-09-10 23:15:36";
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
//	    //���ַ���ת��ΪDate����
//        Date dateNew = ft.parse(date1);
//	    int dMinute = dateNew.getMinutes();//��ȡ����
//	    //ʱ���
//	    long dateStamp = dateNew.getTime();
//	    System.out.println(dateNew);
//	    System.out.println(dMinute);
//	    System.out.println(dateStamp);
		
		
		//ͨ��Number������õ����������ͺ͸����͵�����������С�������ֽ���
	    /*
	     * Number���ࣺInterger Byte Double Float  Char Long
	     * 
	     */
        
		
	    //������Calendar
		Calendar calendar = Calendar.getInstance();
//		Date date = calendar.getTime();
//		calendar.setTime(date);
//		calendar.setTime(new Date());
//		System.out.println("�������ڣ�"+calendar.get(Calendar.DAY_OF_MONTH));
	   
		Random r = new Random();
	    int random  = r.nextInt(2);
	    System.out.println(random);
	}

}
