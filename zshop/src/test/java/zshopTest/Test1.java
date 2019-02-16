package zshopTest;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 *
 * @author LiuXu
 * @version 2018年10月7日上午12:09:01
 */
public class Test1 {

	@Test
	public void test1() {
		String str = "123";
		String h = new Md5Hash(str).toHex();
		System.out.println(h);
		
		
	}

	@Test
	public void testShiro() {
		// 使用init配置文件获取SecurityManager对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 获取SecurityManager对象
		SecurityManager sm = factory.getInstance();
		// 装配到SecurityUtils中
		SecurityUtils.setSecurityManager(sm);
		// 通过SecurityUtils获取subject对象
		Subject subject = SecurityUtils.getSubject();
		// 封装用户信息
		UsernamePasswordToken token = new UsernamePasswordToken("liuxu", "1234");
		System.out.println("是否认证:" + subject.isAuthenticated());
		try {
			// 执行登录操作,如果登录失败则抛出不同的异常
			subject.login(token);
			boolean hasRole = subject.hasRole("admin");
			boolean[] roles = subject.hasRoles(Arrays.asList("admin","user"));
			System.out.println("是否有角色："+hasRole);
			System.out.println(roles[0]+":"+roles[1]);
			System.out.println(Arrays.toString(roles));
			subject.checkPermission("add");
			subject.isPermitted("add");
		} catch (IncorrectCredentialsException e) {
			System.out.println("登录密码错误.");

		} catch (ExcessiveAttemptsException e) {
			System.out.println("登录失败次数过多");

		} catch (LockedAccountException e) {
			System.out.println("帐号已被锁定.");

		} catch (DisabledAccountException e) {
			System.out.println("帐号已被禁用. ");

		} catch (ExpiredCredentialsException e) {
			System.out.println("帐号已过期. ");

		} catch (UnknownAccountException e) {
			System.out.println("帐号不存在.");

		} catch (UnauthorizedException e) {
			System.out.println("您没有得到相应的授权！" + e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("是否认证:" + subject.isAuthenticated());
	}
}
