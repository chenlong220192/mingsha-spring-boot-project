package site.mingsha.boot.example.tomcat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.server.WebServer;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 服务器信息服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class ServerInfoServiceTest {

    @Mock
    private WebServer webServer;

    @InjectMocks
    private ServerInfoService serverInfoService;

    @BeforeEach
    void setUp() throws Exception {
        // 通过反射注入 contextPath
        ReflectionTestUtils.setField(serverInfoService, "contextPath", "/test");
    }

    @Test
    void testGetServerInfo() {
        // Given
        when(webServer.getPort()).thenReturn(8080);

        // When
        Map<String, Object> info = serverInfoService.getServerInfo();

        // Then
        assertNotNull(info);
        assertEquals("Mingsha Tomcat Server", info.get("serverName"));
        assertEquals(System.getProperty("java.version"), info.get("javaVersion"));
        assertEquals(System.getProperty("os.name"), info.get("osName"));
        assertEquals(8080, info.get("serverPort"));
        assertNotNull(info.get("startTime"));
    }

    @Test
    void testGetServerInfo_NoWebServer() {
        // Given - 创建一个无 WebServer 的服务实例
        ServerInfoService serviceWithoutWebServer = new ServerInfoService();
        ReflectionTestUtils.setField(serviceWithoutWebServer, "webServer", null);
        ReflectionTestUtils.setField(serviceWithoutWebServer, "contextPath", "/test");

        // When
        Map<String, Object> info = serviceWithoutWebServer.getServerInfo();

        // Then
        assertNotNull(info);
        assertEquals("Mingsha Tomcat Server", info.get("serverName"));
        assertEquals("unknown", info.get("serverPort")); // webServer 为 null 时返回 unknown
    }

    @Test
    void testGetTomcatConfig() {
        // Given
        when(webServer.getPort()).thenReturn(8080);

        // When
        Map<String, Object> config = serverInfoService.getTomcatConfig();

        // Then
        assertNotNull(config);
        assertEquals("/test", config.get("contextPath"));
        assertEquals("Tomcat/10.0", config.get("serverInfo"));
        assertEquals(8080, config.get("port"));
    }

    @Test
    void testGetConnectionInfo() {
        // When
        Map<String, Object> connections = serverInfoService.getConnectionInfo();

        // Then
        assertNotNull(connections);
        assertEquals(8192, connections.get("maxConnections"));
        assertEquals(0, connections.get("currentConnections"));
        assertEquals(8192, connections.get("availableConnections"));
    }

    @Test
    void testGetThreadInfo() {
        // When
        Map<String, Object> threads = serverInfoService.getThreadInfo();

        // Then
        assertNotNull(threads);
        assertNotNull(threads.get("threadCount"));
        assertNotNull(threads.get("peakThreadCount"));
        assertNotNull(threads.get("daemonThreadCount"));
        assertNotNull(threads.get("totalStartedThreadCount"));

        // 验证线程数类型
        assertTrue(threads.get("threadCount") instanceof Number);
        assertTrue(threads.get("peakThreadCount") instanceof Number);
    }

    @Test
    void testGetThreadInfo_ValuesAreReasonable() {
        // When
        Map<String, Object> threads = serverInfoService.getThreadInfo();

        // Then - 线程数应该是非负数
        int threadCount = ((Number) threads.get("threadCount")).intValue();
        int peakThreadCount = ((Number) threads.get("peakThreadCount")).intValue();
        int daemonThreadCount = ((Number) threads.get("daemonThreadCount")).intValue();

        assertTrue(threadCount >= 0);
        assertTrue(peakThreadCount >= threadCount); // 峰值应该 >= 当前
        assertTrue(daemonThreadCount >= 0);
        assertTrue(daemonThreadCount <= threadCount); // 守护线程应该 <= 总线程
    }
}
