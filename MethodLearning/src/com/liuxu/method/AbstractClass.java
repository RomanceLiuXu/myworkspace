package com.liuxu.method;

public class AbstractClass {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		cat.sleep();
		cat.aa = 10;
		System.out.println(cat.aa = 10);
		
	}

}

abstract class Animal{
	
	int aa;
	public abstract void eat();//抽象方法
	public void sleep(){      //成员方法
		
	}
	
	
}
class Cat extends Animal{
	
	public void eat(){   //重写抽象方法，也称实现抽象方法
		 
	}
   

}



