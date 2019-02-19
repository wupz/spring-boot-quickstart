package cn.dfun.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange; // 交换器
	@Value("${mq.config.queue.info.routing.key}")
	private String routingkey; // 路由键
	
	public void send(String msg) {
		rabbitAmqpTemplate.convertAndSend(exchange, routingkey, msg);
	}
}
