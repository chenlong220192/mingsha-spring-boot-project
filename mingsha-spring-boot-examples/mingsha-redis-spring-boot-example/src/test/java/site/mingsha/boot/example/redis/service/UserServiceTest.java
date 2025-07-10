package site.mingsha.boot.example.redis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testStringOperations() {
        // 测试字符串操作
        userService.setString("test:key", "test:value", 60, TimeUnit.SECONDS);
        String value = userService.getString("test:key");
        assertEquals("test:value", value);
        
        // 测试过期时间
        assertTrue(userService.hasKey("test:key"));
    }

    @Test
    void testHashOperations() {
        // 测试哈希操作
        userService.setHash("test:hash", "field1", "value1");
        userService.setHash("test:hash", "field2", "value2");
        
        Object value1 = userService.getHash("test:hash", "field1");
        Object value2 = userService.getHash("test:hash", "field2");
        
        assertEquals("value1", value1);
        assertEquals("value2", value2);
    }

    @Test
    void testListOperations() {
        // 测试列表操作
        userService.addToList("test:list", "item1");
        userService.addToList("test:list", "item2");
        userService.addToList("test:list", "item3");
        
        List<Object> list = userService.getList("test:list");
        assertEquals(3, list.size());
        assertTrue(list.contains("item1"));
        assertTrue(list.contains("item2"));
        assertTrue(list.contains("item3"));
    }

    @Test
    void testSetOperations() {
        // 测试集合操作
        userService.addToSet("test:set", "member1");
        userService.addToSet("test:set", "member2");
        userService.addToSet("test:set", "member1"); // 重复元素
        
        Set<Object> set = userService.getSet("test:set");
        assertEquals(2, set.size()); // 集合去重
        assertTrue(set.contains("member1"));
        assertTrue(set.contains("member2"));
    }

    @Test
    void testZSetOperations() {
        // 测试有序集合操作
        userService.addToZSet("test:zset", "member1", 1.0);
        userService.addToZSet("test:zset", "member2", 2.0);
        userService.addToZSet("test:zset", "member3", 3.0);
        
        Set<Object> zset = userService.getZSet("test:zset");
        assertEquals(3, zset.size());
    }

    @Test
    void testDeleteAndExists() {
        // 测试删除和存在性检查
        userService.setString("test:delete", "value", 60, TimeUnit.SECONDS);
        assertTrue(userService.hasKey("test:delete"));
        
        boolean deleted = userService.deleteKey("test:delete");
        assertTrue(deleted);
        assertFalse(userService.hasKey("test:delete"));
    }

    @Test
    void testExpireOperations() {
        // 测试过期时间操作
        userService.setString("test:expire", "value", 60, TimeUnit.SECONDS);
        
        // 设置新的过期时间
        boolean success = userService.expire("test:expire", 120, TimeUnit.SECONDS);
        assertTrue(success);
        
        // 获取过期时间
        long expire = userService.getExpire("test:expire", TimeUnit.SECONDS);
        assertTrue(expire > 0);
    }

    @Test
    void testClearCache() {
        // 测试清除缓存
        userService.setString("test:clear1", "value1", 60, TimeUnit.SECONDS);
        userService.setString("test:clear2", "value2", 60, TimeUnit.SECONDS);
        
        userService.clearCache();
        
        assertFalse(userService.hasKey("test:clear1"));
        assertFalse(userService.hasKey("test:clear2"));
    }
} 