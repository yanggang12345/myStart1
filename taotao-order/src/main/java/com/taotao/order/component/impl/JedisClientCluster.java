package com.taotao.order.component.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.order.component.JedisClient;

import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient{

	@Autowired
	private JedisCluster jediscluster;
	@Override
	public String set(String key, String value) {
		return jediscluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jediscluster.get(key);
	}

	@Override
	public Long hset(String key, String item, String value) {
		return jediscluster.hset(key, item,value);
	}

	@Override
	public String hget(String key, String item) {
		return jediscluster.hget(key, item);
	}

	@Override
	public Long incr(String key) {
		return jediscluster.incr(key);
	}

	@Override
	public Long decr(String key) {
		return jediscluster.decr(key);
	}

	@Override
	public Long expire(String key, int second) {
		return jediscluster.expire(key,second);
	}

	@Override
	public Long ttl(String key) {
		return jediscluster.ttl(key);
	}

	@Override
	public Long hdel(String key, String item) {
		return jediscluster.hdel(key,item);
	}

}
