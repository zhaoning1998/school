package cn.com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.pojo.User;
import cn.com.service.UserService;

public class DemoTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService bean = (UserService) context.getBean("userService");
		bean.addUser(new User(null, "张三", "password"));
	}

}
