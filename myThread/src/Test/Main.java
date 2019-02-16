package Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		BlockingQueue queue = new LinkedBlockingQueue<>(6);
//		BlockingQueue queue = new ArrayBlockingQueue<>(10);
		
//		Thread th1 = new Thread(new Productor(queue), "生产线程");
//		Thread th2 = new Thread(new Consumer(queue), "消费线程");
//		th1.start();
//		th2.start();
		char a = '你';
		System.out.println(a);
	}
}
