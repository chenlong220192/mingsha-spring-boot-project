package site.mingsha.boot.example.tomcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.mingsha.boot.example.tomcat.service.ServerInfoService;

import java.util.Map;

/**
 * 服务器信息控制器 - 演示 Tomcat 配置和监控
 */
@RestController
@RequestMapping("/api/server")
public class ServerController {

    @Autowired
    private ServerInfoService serverInfoService;

    /**
     * 获取服务器基本信息
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getServerInfo() {
        return ResponseEntity.ok(serverInfoService.getServerInfo());
    }

    /**
     * 获取 Tomcat 配置信息
     */
    @GetMapping("/tomcat/config")
    public ResponseEntity<Map<String, Object>> getTomcatConfig() {
        return ResponseEntity.ok(serverInfoService.getTomcatConfig());
    }

    /**
     * 获取连接池信息
     */
    @GetMapping("/tomcat/connections")
    public ResponseEntity<Map<String, Object>> getConnectionInfo() {
        return ResponseEntity.ok(serverInfoService.getConnectionInfo());
    }

    /**
     * 获取线程池信息
     */
    @GetMapping("/tomcat/threads")
    public ResponseEntity<Map<String, Object>> getThreadInfo() {
        return ResponseEntity.ok(serverInfoService.getThreadInfo());
    }
} 