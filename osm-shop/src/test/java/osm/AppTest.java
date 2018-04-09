package osm;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eilikce.osm.core.bo.common.Cart;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AppTest {
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	@Value("#{osmProperties['redis.host']}")
	String redisHost;
	@Value("#{osmProperties['redis.port']}")
	Integer redisPort;
	@Value("#{osmProperties['redis.pass']}")
	String redisPass;
	
	@Test
	public void testRedisTemplate() {
		System.out.println("基础redis测试");
		Cart cart = null;
		// -----------------String类型数据操作 start--------------------
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		// String类型数据存储，不设置过期时间，永久性保存
		valueOperations.set("string1", cart);
		// String类型数据存储，设置过期时间为80秒，采用TimeUnit控制时间单位
		valueOperations.set("string2", cart, 80, TimeUnit.SECONDS);
		// 判断key值是否存在，存在则不存储，不存在则存储
		valueOperations.setIfAbsent("string1", cart);
		Cart cart1 = (Cart) valueOperations.get("string1");
		Cart cart2 = (Cart) valueOperations.get("string3");
		System.out.println(cart1);
		System.out.println(cart2);
		
		System.out.println(redisTemplate);
	}
	
	@Test
	public void stringRedis() {
		System.out.println("字符串redis测试");
		
		String str = "testString";
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("testKey", str);
		String rtn = (String) valueOperations.get("testKey");
		System.out.println("字符串redis测试获取返回结果"+rtn);
		
	}
	
	@Test
	public void jedisTest() {
		Jedis jedis = new Jedis(redisHost, redisPort);
		jedis.auth(redisPass);
		System.out.println(jedis.ping());
		jedis.close();
	}
	
}
