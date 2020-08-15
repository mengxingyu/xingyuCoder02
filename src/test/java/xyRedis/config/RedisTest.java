package xyRedis.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.Serializable;


/**
 * @Package: xyRedis.config
 * @ClassName: JedisConfigTest
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/15 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    JedisPool jedisPool;
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    RedisTemplate redisTemplate1;
    @Test
    public void JedisConfigTest () {
        Jedis jedis = jedisPool.getResource();
        jedis.set("year", String.valueOf(24));
    }

    @Test
    public void redisTemplateTest () {
        redisTemplate.opsForList().rightPush("user:1:order", "123456");

    }
    @Test
    public void redisTemplateTest1 () {
        ValueOperations valueOperations = redisTemplate1.opsForValue();
        valueOperations.set("mxy","mxy");
        Object mxy = redisTemplate1.opsForValue().get("mxy");
        System.out.println("value=========="+mxy);
    }
}