package cn.dfun.dao;

public interface JedisClusterDao {
	Boolean exists(String key);
	String get(String key);
	String set(String key,String value);
}
