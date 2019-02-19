package cn.dfun.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dfun.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class JedisClusterDaoTest {
	@Autowired
	private JedisClusterDao jedisClusterDao;
	
	@Test
	public void testSet() {
		jedisClusterDao.set("name", "vincent");
	}
	@Test
	public void testGet() {
		String name = jedisClusterDao.get("name");
		System.out.println(name);
	}
}
