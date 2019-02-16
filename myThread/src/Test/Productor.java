package Test;

import java.util.concurrent.BlockingQueue;

public class Productor extends Thread{
   
   private final BlockingQueue queue; 
   
  public Productor(BlockingQueue queue) {
	this.queue = queue;
}
   
   int num = 1;
	@Override
	public void run() {
		while (true) {
			
		
         try {
			queue.put(num);
			System.out.println("��������:"+num);
			Thread.sleep(1000);
			++num;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	 	
	}
	}
}
