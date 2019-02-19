package cn.dfun.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dfun.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testFindById() {
		userService.findById(1);
		userService.findById(1);
	}

}
