import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
*
*@author LiuXu
*@version 2018年10月17日下午4:02:39 
*/
public class ProxyFactory implements InvocationHandler{

	private Object real;
	
	 public ProxyFactory(Object real) {
		 this.real = real;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		method.invoke(real, args);
		System.out.println("after");
		return null;
	}
	
}
