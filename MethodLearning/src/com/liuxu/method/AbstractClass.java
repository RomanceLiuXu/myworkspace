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
	public abstract void eat();//���󷽷�
	public void sleep(){      //��Ա����
		
	}
	
	
}
class Cat extends Animal{
	
	public void eat(){   //��д���󷽷���Ҳ��ʵ�ֳ��󷽷�
		 
	}
   

}



