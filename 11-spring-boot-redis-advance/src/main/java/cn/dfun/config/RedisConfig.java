package cn.dfun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
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
	@ConfigurationProperties(prefix="redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		// 属性文件信息是在方法返回之后再注入,此处打印无效
		return config;
	}

	/**
	 * 创建JedisConnectionFactory对象,配置redis连接信息
	 * @param config
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="redis")
	public JedisConnectionFactory jedisConnenctionFactory(JedisPoolConfig config) {
		System.out.println(config.getMaxTotal());
		JedisConnectionFactory factory = new JedisConnectionFactory();
		// 关联连接池配置对象
		factory.setPoolConfig(config);
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
