package site.mingsha.boot.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.redis.service.UserService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Redis 控制器 - 演示 Redis 各种操作
 *
 * @author mingsha
 * @date 2025-01-10
 */
@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private UserService userService;

    /**
     * 设置字符串值
     */
    @PostMapping("/string")
    public ResponseEntity<String> setString(@RequestParam String key, 
                                          @RequestParam String value,
                                          @RequestParam(defaultValue = "3600") long timeout) {
        userService.setString(key, value, timeout, TimeUnit.SECONDS);
        return ResponseEntity.ok("字符串值设置成功");
    }

    /**
     * 获取字符串值
     */
    @GetMapping("/string/{key}")
    public ResponseEntity<String> getString(@PathVariable String key) {
        String value = userService.getString(key);
        return ResponseEntity.ok(value != null ? value : "键不存在");
    }

    /**
     * 设置哈希值
     */
    @PostMapping("/hash")
    public ResponseEntity<String> setHash(@RequestParam String key,
                                        @RequestParam String hashKey,
                                        @RequestParam String value) {
        userService.setHash(key, hashKey, value);
        return ResponseEntity.ok("哈希值设置成功");
    }

    /**
     * 获取哈希值
     */
    @GetMapping("/hash/{key}/{hashKey}")
    public ResponseEntity<String> getHash(@PathVariable String key, @PathVariable String hashKey) {
        Object value = userService.getHash(key, hashKey);
        return ResponseEntity.ok(value != null ? value.toString() : "哈希键不存在");
    }

    /**
     * 添加到列表
     */
    @PostMapping("/list")
    public ResponseEntity<String> addToList(@RequestParam String key, @RequestParam String value) {
        userService.addToList(key, value);
        return ResponseEntity.ok("列表项添加成功");
    }

    /**
     * 获取列表
     */
    @GetMapping("/list/{key}")
    public ResponseEntity<List<Object>> getList(@PathVariable String key) {
        List<Object> list = userService.getList(key);
        return ResponseEntity.ok(list);
    }

    /**
     * 添加到集合
     */
    @PostMapping("/set")
    public ResponseEntity<String> addToSet(@RequestParam String key, @RequestParam String value) {
        userService.addToSet(key, value);
        return ResponseEntity.ok("集合项添加成功");
    }

    /**
     * 获取集合
     */
    @GetMapping("/set/{key}")
    public ResponseEntity<java.util.Set<Object>> getSet(@PathVariable String key) {
        java.util.Set<Object> set = userService.getSet(key);
        return ResponseEntity.ok(set);
    }

    /**
     * 设置有序集合
     */
    @PostMapping("/zset")
    public ResponseEntity<String> addToZSet(@RequestParam String key,
                                          @RequestParam String value,
                                          @RequestParam double score) {
        userService.addToZSet(key, value, score);
        return ResponseEntity.ok("有序集合项添加成功");
    }

    /**
     * 获取有序集合
     */
    @GetMapping("/zset/{key}")
    public ResponseEntity<java.util.Set<Object>> getZSet(@PathVariable String key) {
        java.util.Set<Object> zset = userService.getZSet(key);
        return ResponseEntity.ok(zset);
    }

    /**
     * 删除键
     */
    @DeleteMapping("/{key}")
    public ResponseEntity<String> deleteKey(@PathVariable String key) {
        boolean deleted = userService.deleteKey(key);
        return ResponseEntity.ok(deleted ? "键删除成功" : "键不存在");
    }

    /**
     * 检查键是否存在
     */
    @GetMapping("/exists/{key}")
    public ResponseEntity<String> hasKey(@PathVariable String key) {
        boolean exists = userService.hasKey(key);
        return ResponseEntity.ok(exists ? "键存在" : "键不存在");
    }

    /**
     * 设置过期时间
     */
    @PostMapping("/expire/{key}")
    public ResponseEntity<String> expire(@PathVariable String key,
                                       @RequestParam long timeout,
                                       @RequestParam(defaultValue = "SECONDS") TimeUnit unit) {
        boolean success = userService.expire(key, timeout, unit);
        return ResponseEntity.ok(success ? "过期时间设置成功" : "键不存在");
    }

    /**
     * 获取过期时间
     */
    @GetMapping("/expire/{key}")
    public ResponseEntity<String> getExpire(@PathVariable String key,
                                          @RequestParam(defaultValue = "SECONDS") TimeUnit unit) {
        long expire = userService.getExpire(key, unit);
        if (expire == -1) {
            return ResponseEntity.ok("键不存在或没有设置过期时间");
        } else if (expire == -2) {
            return ResponseEntity.ok("键不存在");
        } else {
            return ResponseEntity.ok("过期时间: " + expire + " " + unit.name().toLowerCase());
        }
    }

    /**
     * 清除所有数据
     */
    @PostMapping("/flush")
    public ResponseEntity<String> flushAll() {
        userService.clearCache();
        return ResponseEntity.ok("所有Redis数据已清除");
    }
} 