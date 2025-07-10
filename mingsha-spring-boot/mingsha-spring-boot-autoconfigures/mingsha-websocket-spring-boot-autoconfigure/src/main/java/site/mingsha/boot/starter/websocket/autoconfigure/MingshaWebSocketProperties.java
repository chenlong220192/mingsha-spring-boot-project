package site.mingsha.boot.starter.websocket.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha WebSocket 配置属性
 */
@ConfigurationProperties(prefix = "spring.websocket")
public class MingshaWebSocketProperties {
    /**
     * WebSocket端点路径
     */
    private String endpoint = "/ws";
    
    /**
     * 允许的源
     */
    private String[] allowedOrigins = {"*"};
    
    /**
     * 心跳间隔（毫秒）
     */
    private long heartbeatInterval = 25000;
    
    /**
     * 最大消息大小（字节）
     */
    private int maxMessageSize = 8192;
    
    /**
     * 最大会话数
     */
    private int maxSessions = 1000;
    
    /**
     * 是否启用SockJS
     */
    private boolean sockjsEnabled = true;
    
    /**
     * 是否启用STOMP
     */
    private boolean stompEnabled = false;

    public String getEndpoint() { return endpoint; }
    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }
    public String[] getAllowedOrigins() { return allowedOrigins; }
    public void setAllowedOrigins(String[] allowedOrigins) { this.allowedOrigins = allowedOrigins; }
    public long getHeartbeatInterval() { return heartbeatInterval; }
    public void setHeartbeatInterval(long heartbeatInterval) { this.heartbeatInterval = heartbeatInterval; }
    public int getMaxMessageSize() { return maxMessageSize; }
    public void setMaxMessageSize(int maxMessageSize) { this.maxMessageSize = maxMessageSize; }
    public int getMaxSessions() { return maxSessions; }
    public void setMaxSessions(int maxSessions) { this.maxSessions = maxSessions; }
    public boolean isSockjsEnabled() { return sockjsEnabled; }
    public void setSockjsEnabled(boolean sockjsEnabled) { this.sockjsEnabled = sockjsEnabled; }
    public boolean isStompEnabled() { return stompEnabled; }
    public void setStompEnabled(boolean stompEnabled) { this.stompEnabled = stompEnabled; }
} 