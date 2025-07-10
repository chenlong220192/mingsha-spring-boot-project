package site.mingsha.boot.example.tomcat.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServerInfoServiceTest {
    @Autowired
    private ServerInfoService serverInfoService;

    @Test
    void testGetServerInfo() {
        Map<String, Object> info = serverInfoService.getServerInfo();
        assertNotNull(info);
        assertNotNull(info.get("serverName"));
        assertNotNull(info.get("javaVersion"));
        assertNotNull(info.get("osName"));
        assertNotNull(info.get("serverPort"));
    }

    @Test
    void testGetTomcatConfig() {
        Map<String, Object> config = serverInfoService.getTomcatConfig();
        assertNotNull(config);
        assertNotNull(config.get("serverInfo"));
    }

    @Test
    void testGetConnectionInfo() {
        Map<String, Object> connections = serverInfoService.getConnectionInfo();
        assertNotNull(connections);
        assertNotNull(connections.get("maxConnections"));
        assertNotNull(connections.get("currentConnections"));
        assertNotNull(connections.get("availableConnections"));
    }

    @Test
    void testGetThreadInfo() {
        Map<String, Object> threads = serverInfoService.getThreadInfo();
        assertNotNull(threads);
        assertNotNull(threads.get("threadCount"));
        assertNotNull(threads.get("peakThreadCount"));
        assertNotNull(threads.get("daemonThreadCount"));
    }
} 