package cn.dfun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 存字符串 
	 */
	@Test
	public void testSet() {
		redisTemplate.opsForValue().set("key", "dfun");
	}
	/**
	 * 取字符串
	 */
	@Test
	public void testGet() {
		String value = (String)redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
}
