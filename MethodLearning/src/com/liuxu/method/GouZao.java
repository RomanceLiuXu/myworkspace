package com.liuxu.method;

public class GouZao {

	public static void main(String[] args) {
		
//		Person person = new Person(1);	
	    Boy boy = new Boy("James", "��", 36, 195,"own");
	//   Wang wang = new Wang(1);
	    System.out.println(boy.getX());
	    System.out.println(boy.name);
	}

}
class Person{
	public String name;
	public String gender;
	public int age;
	public double height;
	
	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public Person(){
		
	}

	public Person(String name,String gender,int age,double height){
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;	
	}
}
/*1.���췽�����ܱ��̳к���д
 *2.���췽�����Ա�����
 *3.��ʹ�����๹�췽��ʱ�������๹�췽���ķ�����ĵ�һ�л�
 *  Ĭ�ϵ��ø�����޲����Ĺ��췽��
 *4.������û���޲����Ĺ��췽�����������Զ�������๹�췽����
 *  ��Ҫ�ڵ�һ�м�����ø��๹�췽���Ĵ���
 *5.������Ĺ��췽����������ø���Ĺ��췽������ֻ�ܵ���һ��  
 */
class Boy extends Person{
	private String x;
	
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}

	public Boy(){}
	public Boy(String name,String gender,int age,double height,String x){
		
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//		this.height = height;
	super(name, gender, age, height);
    this.x = x;
	}
}

// 
//	public Boy(){
//		//super([�����б�]); Ĭ�ϵ��ø���Ĺ��췽��
//		super(1);
//		
//	System.out.println("Boy�Ĺ��췽��");	
//	}
//	
//}
class Wang extends Boy{

}
class Girl extends Person{
	public Girl(){}
	public Girl(String name,String gender,int age,double height){
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//		this.height = height;
	super(name, gender, age, height);
}
}
