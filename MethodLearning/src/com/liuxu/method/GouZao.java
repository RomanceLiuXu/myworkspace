package com.liuxu.method;

public class GouZao {

	public static void main(String[] args) {
		
//		Person person = new Person(1);	
	    Boy boy = new Boy("James", "男", 36, 195,"own");
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
/*1.构造方法不能被继承和重写
 *2.构造方法可以被重载
 *3.当使用子类构造方法时，在子类构造方法的方法体的第一行会
 *  默认调用父类的无参数的构造方法
 *4.当父类没有无参数的构造方法，我们在自定义的子类构造方法中
 *  需要在第一行加入调用父类构造方法的代码
 *5.在子类的构造方法，必须调用父类的构造方法并且只能调用一个  
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
//		//super([参数列表]); 默认调用父类的构造方法
//		super(1);
//		
//	System.out.println("Boy的构造方法");	
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
