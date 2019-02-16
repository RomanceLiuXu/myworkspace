package Test;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

	private BlockingQueue queue;
	
	public Consumer(BlockingQueue queue){
		this.queue = queue;
		
	}
	
	public void run() {
		
		while (true) {
			try {
				System.out.println("正在消费--:"+queue.take());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	};
}
