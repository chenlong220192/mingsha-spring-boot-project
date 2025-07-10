package site.mingsha.boot.example.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.mybatis.entity.User;
import site.mingsha.boot.example.mybatis.service.UserService;

import java.util.List;

/**
 * 用户控制器
 *
 * @author mingsha
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 创建用户
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
    
    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * 根据用户名查询用户
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * 查询所有用户
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    /**
     * 根据年龄范围查询用户
     */
    @GetMapping("/age-range")
    public ResponseEntity<List<User>> getUsersByAgeRange(
            @RequestParam Integer minAge,
            @RequestParam Integer maxAge) {
        List<User> users = userService.getUsersByAgeRange(minAge, maxAge);
        return ResponseEntity.ok(users);
    }
    
    /**
     * 更新用户信息
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        boolean updated = userService.updateUser(user);
        if (updated) {
            return ResponseEntity.ok("用户更新成功");
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("用户删除成功");
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * 获取用户总数
     */
    @GetMapping("/count")
    public ResponseEntity<Integer> getUserCount() {
        int count = userService.getUserCount();
        return ResponseEntity.ok(count);
    }
    
    /**
     * 根据地址模糊查询用户
     */
    @GetMapping("/address")
    public ResponseEntity<List<User>> getUsersByAddressLike(@RequestParam String address) {
        List<User> users = userService.getUsersByAddressLike(address);
        return ResponseEntity.ok(users);
    }
    
    /**
     * 批量创建用户
     */
    @PostMapping("/batch")
    public ResponseEntity<String> batchCreateUsers(@RequestBody List<User> users) {
        userService.batchCreateUsers(users);
        return ResponseEntity.ok("批量创建用户成功");
    }
} 