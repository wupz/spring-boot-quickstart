package cn.dfun.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
	@Bean
	public Queue createQueue() {
		return new Queue("hello-queue");
	}
}
