package maven02;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
*
*@author LiuXu
*@version 2018年10月15日下午10:04:46 
*/
public class EncrypTest {

	@Test
	public void testPwd(){
		String md5Pwd = DigestUtils.md5("ss".getBytes()).toString();
		System.out.println(md5Pwd);
		
	}
	
}
