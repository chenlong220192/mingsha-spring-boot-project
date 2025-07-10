package site.mingsha.boot.starter.rabbitmq.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha RabbitMQ 配置属性
 */
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class MingshaRabbitMQProperties {
    /**
     * RabbitMQ服务器地址
     */
    private String host = "localhost";
    
    /**
     * RabbitMQ服务器端口
     */
    private int port = 5672;
    
    /**
     * RabbitMQ用户名
     */
    private String username = "guest";
    
    /**
     * RabbitMQ密码
     */
    private String password = "guest";
    
    /**
     * 虚拟主机
     */
    private String virtualHost = "/";
    
    /**
     * 连接超时时间（毫秒）
     */
    private int connectionTimeout = 60000;
    
    /**
     * 请求心跳超时时间（毫秒）
     */
    private int requestedHeartBeat = 60;
    
    /**
     * 自动恢复连接
     */
    private boolean automaticRecoveryEnabled = true;
    
    /**
     * 网络恢复间隔（毫秒）
     */
    private long networkRecoveryInterval = 5000;

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getVirtualHost() { return virtualHost; }
    public void setVirtualHost(String virtualHost) { this.virtualHost = virtualHost; }
    public int getConnectionTimeout() { return connectionTimeout; }
    public void setConnectionTimeout(int connectionTimeout) { this.connectionTimeout = connectionTimeout; }
    public int getRequestedHeartBeat() { return requestedHeartBeat; }
    public void setRequestedHeartBeat(int requestedHeartBeat) { this.requestedHeartBeat = requestedHeartBeat; }
    public boolean isAutomaticRecoveryEnabled() { return automaticRecoveryEnabled; }
    public void setAutomaticRecoveryEnabled(boolean automaticRecoveryEnabled) { this.automaticRecoveryEnabled = automaticRecoveryEnabled; }
    public long getNetworkRecoveryInterval() { return networkRecoveryInterval; }
    public void setNetworkRecoveryInterval(long networkRecoveryInterval) { this.networkRecoveryInterval = networkRecoveryInterval; }
} 