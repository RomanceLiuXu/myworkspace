package com.liuxu.myredis;

import java.util.HashMap;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
//java代码操作redis数据库
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {

	JedisPool pool;

	Jedis jedis;

	@Before
	public void init() {
		pool = new JedisPool(new JedisPoolConfig(), "localhost");
		jedis = pool.getResource();
	}

	@Test
	public void testString() {
		// 1.添加数据
		jedis.set("username", "张三");
		// 在原来value值基础上再去添加数据
		jedis.append("username", "三三");
		// 通过key值获取value
		String value = jedis.get("username");
		System.out.println(value);

		// 删除key-value键值对
		jedis.del("username");
		value = jedis.get("username");
		System.out.println(value);

		// 同时插入两个以上key-value键值对
		jedis.mset("username", "李四", "password", "1234", "age", "12");
		// 根据key值获取多个键值对
		System.out.println(jedis.mget("username", "age"));
	}

	/**
	 * jedis对redis中map类型数据操作
	 */
	@Test
	public void testMap() {
		HashMap<String, String> map = new HashMap<>();
		map.put("job", "sales");
		map.put("salary", "10000");
		// 将map数据存储到redis中
		jedis.hmset("emp", map);
		System.out.println(jedis.hmget("emp", "job", "salary"));

		// 删除map中的一个key-value键值对
		jedis.hdel("emp", "job");
		System.out.println(jedis.hmget("emp", "job", "salary"));

		// 遍历所有的key值和value值
		System.out.println("所有key值:" + jedis.hkeys("emp"));
		System.out.println("所有value值:" + jedis.hvals("emp"));

		// 遍历map集合
		Set<String> keys = jedis.hkeys("emp");
		for (String key : keys) {
			String value = jedis.hmget("emp", key).get(0);
			System.out.println(key + ":" + value);
		}

	}

}
