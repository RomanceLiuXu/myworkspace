package myThread;

public class Test {

	public static void main(String[] args) {
	Account account = new Account();
		Person p1 = new Person();
		p1.setpName("丈夫");
		p1.setgMoney(100);
		p1.setAccount(account);
		Person p2 = new Person();
		p2.setpName("妻子");
		p2.setgMoney(300);
		p1.start();
		p2.start();
		p2.setAccount(account);
	}
	
}

class Person extends Thread{
	private String pName;
	private Account account;
	private double gMoney;
	
	
	public void getMoney(double gMoney) {
		//取的钱数
		this.gMoney = gMoney;
		synchronized (account) {
			System.out.println(pName+"正在取钱...");
			try {
				account.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            account.setAllmoey(account.getAllmoey() - gMoney);
            System.out.println(pName+"取了"+gMoney+",账户余额为"+account.getAllmoey());
			
			
		}
		
	}
	
	@Override
	public void run() {
	
		super.run();
		getMoney(gMoney);
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getgMoney() {
		return gMoney;
	}
	public void setgMoney(double gMoney) {
		this.gMoney = gMoney;
	}
	
	
}


class Account extends Thread{

	private double Allmoey = 1000;
	
	
	
	public double getAllmoey() {
		return Allmoey;
	}
	
	public void getMoney(double gMoney) {

		
	}

	public void setAllmoey(double allmoey) {
		Allmoey = allmoey;
	}


	
}