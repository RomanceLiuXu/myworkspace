package Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		BlockingQueue queue = new LinkedBlockingQueue<>(6);
//		BlockingQueue queue = new ArrayBlockingQueue<>(10);
		
//		Thread th1 = new Thread(new Productor(queue), "�����߳�");
//		Thread th2 = new Thread(new Consumer(queue), "�����߳�");
//		th1.start();
//		th2.start();
		char a = '��';
		System.out.println(a);
	}
}
