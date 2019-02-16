package myThread;

import java.io.IOException;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleRunnable implements Runnable{

	private int ticket = 20;

    @Override
    public void run() {
        while(true) {//判断条件做了修改
            synchronized(this) {//锁加在循环判断里面，只有满足条件才能执行卖票操作
                if (ticket > 0) {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date())+ Thread.currentThread().getName() + "卖出了第" + (20 - ticket + 1) + "张票");
                    ticket--;
                } else {
                	System.out.println("票已卖完");
                	break;
                }
            }

            try {//这里的操作是为了方便线程间自动切换，如果不加的话，可能结果也是票全让老王线程给卖了
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

	
	}


