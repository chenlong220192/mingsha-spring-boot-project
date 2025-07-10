package site.mingsha.boot.example.tomcat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务器信息服务 - 演示 Tomcat 监控
 */
@Service
public class ServerInfoService {

    @Autowired(required = false)
    private TomcatWebServer tomcatWebServer;

    @Value("${server.servlet.context-path:/}")
    private String contextPath;

    /**
     * 获取服务器基本信息
     */
    public Map<String, Object> getServerInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("serverName", "Mingsha Tomcat Server");
        info.put("javaVersion", System.getProperty("java.version"));
        info.put("osName", System.getProperty("os.name"));
        info.put("osVersion", System.getProperty("os.version"));
        info.put("serverPort", tomcatWebServer != null ? tomcatWebServer.getPort() : "unknown");
        info.put("startTime", System.currentTimeMillis());
        return info;
    }

    /**
     * 获取 Tomcat 配置信息
     */
    public Map<String, Object> getTomcatConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("contextPath", contextPath);
        config.put("serverInfo", "Tomcat/10.0");
        if (tomcatWebServer != null) {
            config.put("port", tomcatWebServer.getPort());
        } else {
            config.put("port", "unknown");
        }
        return config;
    }

    /**
     * 获取连接池信息
     */
    public Map<String, Object> getConnectionInfo() {
        Map<String, Object> connections = new HashMap<>();
        connections.put("maxConnections", 8192);
        connections.put("currentConnections", 0);
        connections.put("availableConnections", 8192);
        return connections;
    }

    /**
     * 获取线程池信息
     */
    public Map<String, Object> getThreadInfo() {
        Map<String, Object> threads = new HashMap<>();
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        threads.put("threadCount", threadBean.getThreadCount());
        threads.put("peakThreadCount", threadBean.getPeakThreadCount());
        threads.put("daemonThreadCount", threadBean.getDaemonThreadCount());
        threads.put("totalStartedThreadCount", threadBean.getTotalStartedThreadCount());
        return threads;
    }
} 