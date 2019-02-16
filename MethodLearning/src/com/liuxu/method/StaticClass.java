package com.liuxu.method;
//static 关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。
//静态变量也被称为类变量。局部变量不能被声明为 static 变量。

//static 关键字用来声明独立于对象的静态方法。静态方法不能使用类的非静态变量。
//静态方法从参数列表得到数据，然后计算这些数据

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
	//b = 10; //不能对非静态b进行静态引用（静态方法不能直接引用成员变量和方法）
	  
  }
  public void test(){  //成员方法中可以直接引用类方法和类变量
	name = "";
	a = 10;
	b = 5;  
    run();
  }
  
  
}

