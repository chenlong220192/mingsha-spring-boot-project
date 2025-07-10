package site.mingsha.boot.example.mybatis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import site.mingsha.boot.example.mybatis.entity.User;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试类
 *
 * @author mingsha
 * @since 1.0.0
 */
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testCreateUser() {
        User user = new User("testuser", "test@example.com", "13800138000", 25, "北京市朝阳区");
        User createdUser = userService.createUser(user);
        
        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals("testuser", createdUser.getUsername());
        assertEquals("test@example.com", createdUser.getEmail());
    }
    
    @Test
    public void testGetUserById() {
        // 先创建用户
        User user = new User("testuser2", "test2@example.com", "13800138001", 30, "上海市浦东新区");
        User createdUser = userService.createUser(user);
        
        // 根据ID查询
        User foundUser = userService.getUserById(createdUser.getId());
        
        assertNotNull(foundUser);
        assertEquals(createdUser.getId(), foundUser.getId());
        assertEquals("testuser2", foundUser.getUsername());
    }
    
    @Test
    public void testGetUserByUsername() {
        // 先创建用户
        User user = new User("testuser3", "test3@example.com", "13800138002", 28, "广州市天河区");
        userService.createUser(user);
        
        // 根据用户名查询
        User foundUser = userService.getUserByUsername("testuser3");
        
        assertNotNull(foundUser);
        assertEquals("testuser3", foundUser.getUsername());
        assertEquals("test3@example.com", foundUser.getEmail());
    }
    
    @Test
    public void testUpdateUser() {
        // 先创建用户
        User user = new User("testuser4", "test4@example.com", "13800138003", 35, "深圳市南山区");
        User createdUser = userService.createUser(user);
        
        // 更新用户信息
        createdUser.setAge(36);
        createdUser.setAddress("深圳市福田区");
        boolean updated = userService.updateUser(createdUser);
        
        assertTrue(updated);
        
        // 验证更新结果
        User updatedUser = userService.getUserById(createdUser.getId());
        assertEquals(36, updatedUser.getAge());
        assertEquals("深圳市福田区", updatedUser.getAddress());
    }
    
    @Test
    public void testDeleteUser() {
        // 先创建用户
        User user = new User("testuser5", "test5@example.com", "13800138004", 40, "杭州市西湖区");
        User createdUser = userService.createUser(user);
        
        // 删除用户
        boolean deleted = userService.deleteUser(createdUser.getId());
        
        assertTrue(deleted);
        
        // 验证用户已被删除
        User deletedUser = userService.getUserById(createdUser.getId());
        assertNull(deletedUser);
    }
    
    @Test
    public void testGetUsersByAgeRange() {
        // 创建不同年龄的用户
        User user1 = new User("user1", "user1@example.com", "13800138005", 20, "成都市锦江区");
        User user2 = new User("user2", "user2@example.com", "13800138006", 25, "武汉市江汉区");
        User user3 = new User("user3", "user3@example.com", "13800138007", 30, "西安市雁塔区");
        
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        
        // 查询25-30岁的用户
        List<User> users = userService.getUsersByAgeRange(25, 30);
        
        assertNotNull(users);
        assertTrue(users.size() >= 2);
        users.forEach(user -> {
            assertTrue(user.getAge() >= 25 && user.getAge() <= 30);
        });
    }
    
    @Test
    public void testGetUsersByAddressLike() {
        // 创建不同地址的用户
        User user1 = new User("user4", "user4@example.com", "13800138008", 22, "北京市海淀区");
        User user2 = new User("user5", "user5@example.com", "13800138009", 27, "北京市朝阳区");
        User user3 = new User("user6", "user6@example.com", "13800138010", 32, "上海市黄浦区");
        
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        
        // 查询地址包含"北京"的用户
        List<User> users = userService.getUsersByAddressLike("北京");
        
        assertNotNull(users);
        assertTrue(users.size() >= 2);
        users.forEach(user -> {
            assertTrue(user.getAddress().contains("北京"));
        });
    }
    
    @Test
    public void testBatchCreateUsers() {
        List<User> users = Arrays.asList(
            new User("batch1", "batch1@example.com", "13800138011", 24, "南京市鼓楼区"),
            new User("batch2", "batch2@example.com", "13800138012", 26, "苏州市姑苏区"),
            new User("batch3", "batch3@example.com", "13800138013", 29, "无锡市梁溪区")
        );
        
        userService.batchCreateUsers(users);
        
        // 验证批量创建结果
        for (User user : users) {
            User foundUser = userService.getUserByUsername(user.getUsername());
            assertNotNull(foundUser);
            assertEquals(user.getEmail(), foundUser.getEmail());
        }
    }
    
    @Test
    public void testGetUserCount() {
        int initialCount = userService.getUserCount();
        
        // 创建新用户
        User user = new User("countuser", "count@example.com", "13800138014", 33, "重庆市渝中区");
        userService.createUser(user);
        
        int newCount = userService.getUserCount();
        assertEquals(initialCount + 1, newCount);
    }
} 