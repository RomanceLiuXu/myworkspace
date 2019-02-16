package com.liuxu.myredis;

import java.util.HashMap;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
//java�������redis���ݿ�
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
		// 1.�������
		jedis.set("username", "����");
		// ��ԭ��valueֵ��������ȥ�������
		jedis.append("username", "����");
		// ͨ��keyֵ��ȡvalue
		String value = jedis.get("username");
		System.out.println(value);

		// ɾ��key-value��ֵ��
		jedis.del("username");
		value = jedis.get("username");
		System.out.println(value);

		// ͬʱ������������key-value��ֵ��
		jedis.mset("username", "����", "password", "1234", "age", "12");
		// ����keyֵ��ȡ�����ֵ��
		System.out.println(jedis.mget("username", "age"));
	}

	/**
	 * jedis��redis��map�������ݲ���
	 */
	@Test
	public void testMap() {
		HashMap<String, String> map = new HashMap<>();
		map.put("job", "sales");
		map.put("salary", "10000");
		// ��map���ݴ洢��redis��
		jedis.hmset("emp", map);
		System.out.println(jedis.hmget("emp", "job", "salary"));

		// ɾ��map�е�һ��key-value��ֵ��
		jedis.hdel("emp", "job");
		System.out.println(jedis.hmget("emp", "job", "salary"));

		// �������е�keyֵ��valueֵ
		System.out.println("����keyֵ:" + jedis.hkeys("emp"));
		System.out.println("����valueֵ:" + jedis.hvals("emp"));

		// ����map����
		Set<String> keys = jedis.hkeys("emp");
		for (String key : keys) {
			String value = jedis.hmget("emp", key).get(0);
			System.out.println(key + ":" + value);
		}

	}

}
