package myThread;



public class mySleep {

	public static void main(String[] args) {
		
		Object object = new Object();
		Product product = new Product();
		Demo1 demo1 = new Demo1();
		Demo2 demo2 = new Demo2();
		demo1.setProduct(product);
		demo2.setProduct(product);
		demo1.start();
		demo2.start();
		
	}
}

class Demo1  extends Thread{
	private Object obj;
	private Product product;
	@Override
	public void run() {
		super.run();
		synchronized (product) {
//			for (int i = 0; i < 10; i++) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName()+":"+i);
//			}
			product.method1();
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
class Demo2 extends Thread{
private Object obj;
private Product product;
	@Override
	public void run() {
		super.run();
		synchronized (product) {
//			for (int i = 0; i < 10; i++) {
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName()+":"+i);
//			}
			product.method2();
		}
	}

	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
class Product{
	
	public void method1() {
		for (int i = 0; i < 5; i++) {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//			
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+":"+i);
			
		}
		
	}
	
	public void method2() {
		for (int i = 5; i > 0; i--) {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//			
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+":"+i);
			
		}
		
	}
}
	
	
