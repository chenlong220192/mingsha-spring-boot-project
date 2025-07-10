package site.mingsha.boot.example.tomcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Tomcat 示例控制器
 *
 * @author mingsha
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/tomcat")
public class TomcatController {

    @Autowired(required = false)
    private TomcatServletWebServerFactory tomcatFactory;

    /**
     * 获取应用信息
     */
    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "Mingsha Tomcat Example");
        info.put("version", "1.0.0");
        info.put("description", "Spring Boot Tomcat 示例应用");
        info.put("timestamp", System.currentTimeMillis());
        return info;
    }

    /**
     * 获取 Tomcat 配置信息
     */
    @GetMapping("/config")
    public Map<String, Object> getTomcatConfig() {
        Map<String, Object> config = new HashMap<>();
        
        if (tomcatFactory != null) {
            config.put("port", tomcatFactory.getPort());
            config.put("contextPath", tomcatFactory.getContextPath());
            // config.put("serverName", tomcatFactory.getServerName());
            // config.put("protocol", tomcatFactory.getProtocol());
        } else {
            config.put("message", "Tomcat 配置未找到");
        }
        
        return config;
    }

    /**
     * 获取服务器状态
     */
    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "UP");
        status.put("message", "Tomcat 服务器运行正常");
        status.put("memory", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        status.put("totalMemory", Runtime.getRuntime().totalMemory());
        status.put("maxMemory", Runtime.getRuntime().maxMemory());
        status.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        return status;
    }

    /**
     * 测试并发请求
     */
    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Tomcat 请求处理正常");
        result.put("thread", Thread.currentThread().getName());
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }
} 