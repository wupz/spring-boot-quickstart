package cn.dfun.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dfun.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class QueueTest {
	@Autowired
	private Sender sender;
	@Test
	public void testSend() {
		sender.send("hello world!");
	}
}
