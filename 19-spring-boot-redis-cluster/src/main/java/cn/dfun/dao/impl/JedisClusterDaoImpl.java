package cn.dfun.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.dfun.dao.JedisClusterDao;
import redis.clients.jedis.JedisCluster;
@Repository
public class JedisClusterDaoImpl implements JedisClusterDao {
	@Resource
	private JedisCluster jedisClients;
	@Override
	public Boolean exists(String key) {
		return jedisClients.exists(key);
	}
	@Override
	public String get(String key) {
		return jedisClients.get(key);
	}
	@Override
	public String set(String key, String value) {
		return jedisClients.set(key, value);
	}
}
