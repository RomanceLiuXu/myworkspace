package myThread;

public class MyMain {

	public static void main(String[] args) {
		
		SaleRunnable r = new SaleRunnable();
		Thread t1 = new Thread(r,"老王");
		Thread t2 = new Thread(r,"老张");
		Thread t3 = new Thread(r,"老李");
		
		
		t1.start();
		t2.start();
		t3.start();
	
	
	
	}
    
    
}
