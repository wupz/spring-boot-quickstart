package cn.dfun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	/**
	 * 创建JedisPoolConfig对象,配置连接池
	 * @return
	 */
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大空闲数
		config.setMaxIdle(10);
		// 最小空闲数
		config.setMinIdle(5);
		// 最大连接数
		config.setMaxTotal(20);
		return config;
	}

	/**
	 * 创建JedisConnectionFactory对象,配置redis连接信息
	 * @param config
	 * @return
	 */
	@Bean
	public JedisConnectionFactory jedisConnenctionFactory(JedisPoolConfig config) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		// 关联连接池配置对象
		factory.setPoolConfig(config);
		// 主机地址
		factory.setHostName("192.168.154.101");
		// 端口
		factory.setPort(6379);
		return factory;
	}
	/**
	 * 创建RedisTemplate:用于执行redis操作的方法
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		// 关联JedisConnectionFactory
		template.setConnectionFactory(factory);
		// 为key设置序列化器
		template.setKeySerializer(new StringRedisSerializer());
		// 为value设置序列化器
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}
}
