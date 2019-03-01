package cn.dfun.queue;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(
	bindings = @QueueBinding(
		value = @Queue(value = "${mq.config.queue.error}"), 	// 队列名称
		exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT), // 交换器名称\类型 
		key = "${mq.config.queue.error.routing.key}") // 路由键
)
public class ErrorReceiver {
	@RabbitHandler
	public void process(String msg) {
		System.out.println("ErrorReceiver:" + msg);
	}
}
