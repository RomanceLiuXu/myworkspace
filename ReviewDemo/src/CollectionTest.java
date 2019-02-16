import java.lang.reflect.Proxy;
import java.util.List;

/**
 *
 * @author LiuXu
 * @version 2018年10月17日下午3:51:52
 */
public class CollectionTest {

	public static void main(String[] args) {
		
		RealObject realObject = new RealObject();
		ProxyFactory factory = new ProxyFactory(realObject);
		ISubject is = (ISubject)Proxy.newProxyInstance(realObject.getClass().getClassLoader(), realObject.getClass().getInterfaces(), factory);
		is.rent();
	}

}
