package site.mingsha.boot.example.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Actuator 示例控制器
 *
 * @author mingsha
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/actuator")
public class ActuatorController {

    /**
     * 获取应用信息
     */
    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "Mingsha Actuator Example");
        info.put("version", "1.0.0");
        info.put("description", "Spring Boot Actuator 示例应用");
        info.put("timestamp", System.currentTimeMillis());
        return info;
    }

    /**
     * 健康检查端点
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("message", "应用运行正常");
        return health;
    }

    /**
     * 获取系统状态
     */
    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("memory", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        status.put("totalMemory", Runtime.getRuntime().totalMemory());
        status.put("maxMemory", Runtime.getRuntime().maxMemory());
        status.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        return status;
    }
} 