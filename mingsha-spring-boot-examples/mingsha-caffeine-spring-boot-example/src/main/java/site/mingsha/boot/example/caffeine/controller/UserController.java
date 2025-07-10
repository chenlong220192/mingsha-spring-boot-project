package site.mingsha.boot.example.caffeine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.caffeine.entity.User;
import site.mingsha.boot.example.caffeine.service.UserService;

import java.util.List;

/**
 * 用户控制器 - 演示 Caffeine 缓存 API
 *
 * @author mingsha
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * 根据ID获取用户
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    /**
     * 根据用户名获取用户
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    /**
     * 创建用户
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * 更新用户
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    /**
     * 清除所有缓存
     */
    @PostMapping("/cache/clear")
    public ResponseEntity<String> clearCache() {
        userService.clearCache();
        return ResponseEntity.ok("缓存已清除");
    }

    /**
     * 获取缓存统计信息
     */
    @GetMapping("/cache/stats")
    public ResponseEntity<String> getCacheStats() {
        String stats = userService.getCacheStats();
        return ResponseEntity.ok(stats);
    }

    /**
     * 测试缓存性能
     */
    @GetMapping("/cache/test/{id}")
    public ResponseEntity<String> testCache(@PathVariable Long id) {
        long startTime = System.currentTimeMillis();
        
        // 第一次查询（缓存未命中）
        User user1 = userService.getUserById(id);
        long firstQueryTime = System.currentTimeMillis() - startTime;
        
        // 第二次查询（缓存命中）
        long secondStartTime = System.currentTimeMillis();
        User user2 = userService.getUserById(id);
        long secondQueryTime = System.currentTimeMillis() - secondStartTime;
        
        String result = String.format(
            "缓存测试结果:\n" +
            "用户: %s\n" +
            "第一次查询时间: %dms (缓存未命中)\n" +
            "第二次查询时间: %dms (缓存命中)\n" +
            "性能提升: %.2f倍",
            user1 != null ? user1.getUsername() : "未找到",
            firstQueryTime,
            secondQueryTime,
            (double) firstQueryTime / secondQueryTime
        );
        
        return ResponseEntity.ok(result);
    }
} 