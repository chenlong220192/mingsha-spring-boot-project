package site.mingsha.boot.example.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.aop.service.UserService;

/**
 * 用户控制器 - 演示AOP切面功能
 *
 * @author mingsha
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     */
    @GetMapping("/{username}")
    public ResponseEntity<String> getUser(@PathVariable String username) {
        String info = userService.getUserInfo(username);
        return ResponseEntity.ok(info);
    }

    /**
     * 新增用户
     */
    @PostMapping
    public ResponseEntity<String> addUser(@RequestParam String username) {
        userService.addUser(username);
        return ResponseEntity.ok("用户添加成功: " + username);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok("用户删除成功: " + username);
    }
} 