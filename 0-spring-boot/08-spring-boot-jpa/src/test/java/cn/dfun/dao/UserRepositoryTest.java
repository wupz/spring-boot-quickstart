package cn.dfun.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dfun.App;
import cn.dfun.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setAge(20);
		user.setName("张三");
		userRepository.save(user);
	}

}
