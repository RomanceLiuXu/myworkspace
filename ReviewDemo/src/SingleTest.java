
/**
*
*@author LiuXu
*@version 2018年10月17日下午3:55:56 
*/
public class SingleTest {

	private  static volatile SingleTest lazySingle;
	
	private SingleTest(){
		
	}
	
	public static SingleTest getSingle(){
		if (lazySingle==null) {
			synchronized (SingleTest.class) {
				if (lazySingle==null) {
					lazySingle=new SingleTest();
				}
			}
		}
		return lazySingle;
	}
	
}
