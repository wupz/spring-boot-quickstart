package cn.dfun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dfun.pojo.User;

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
	/**
	 * 存对象
	 */
	@Test
	public void testSetUser() {
		User user = new User(1, "张三", 20);
		// 使用字符串序列化器存对象会报错,使用JDK序列化器把对象转换成字节,以字符形式存
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.opsForValue().set("user", user);
	}
	/**
	 * 取对象
	 */
	@Test
	public void testGetUser() {
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		User user = (User)redisTemplate.opsForValue().get("user");
		System.out.println(user);
	}
	/**
	 * 存json对象
	 */
	@Test
	public void testSetJson() {
		User user = new User(1, "张三", 20);
		// Jackson2序列化器,不带2的已废弃
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		redisTemplate.opsForValue().set("user_json", user);
	}
	/**
	 * 取json对象
	 */
	@Test
	public void testGetJson() {
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		User user = (User)redisTemplate.opsForValue().get("user_json");
		System.out.println(user);
	}
}
