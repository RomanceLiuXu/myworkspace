package com.liuxu.method;
//static �ؼ����������������ڶ���ľ�̬����������һ����ʵ�������ٶ������ľ�̬����ֻ��һ�ݿ�����
//��̬����Ҳ����Ϊ��������ֲ��������ܱ�����Ϊ static ������

//static �ؼ����������������ڶ���ľ�̬��������̬��������ʹ����ķǾ�̬������
//��̬�����Ӳ����б�õ����ݣ�Ȼ�������Щ����

public class StaticClass {

	public static void main(String[] args) {
	//Person.name = "";
	Person1.a = 5;
    Person1 person = new Person1();
	person.b = 10;
	
	}

}
class Person1{
  public static String name;
  public static int a;
  public int b;	
  
  public static void run(){
	//b = 10; //���ܶԷǾ�̬b���о�̬���ã���̬��������ֱ�����ó�Ա�����ͷ�����
	  
  }
  public void test(){  //��Ա�����п���ֱ�������෽���������
	name = "";
	a = 10;
	b = 5;  
    run();
  }
  
  
}

