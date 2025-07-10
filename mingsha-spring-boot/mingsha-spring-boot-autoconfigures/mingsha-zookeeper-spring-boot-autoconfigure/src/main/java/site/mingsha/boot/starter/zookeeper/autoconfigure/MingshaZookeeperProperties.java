package site.mingsha.boot.starter.zookeeper.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha Zookeeper 配置属性
 */
@ConfigurationProperties(prefix = "spring.zookeeper")
public class MingshaZookeeperProperties {
    /**
     * Zookeeper服务器地址
     */
    private String connectString = "localhost:2181";
    
    /**
     * 会话超时时间（毫秒）
     */
    private int sessionTimeoutMs = 60000;
    
    /**
     * 连接超时时间（毫秒）
     */
    private int connectionTimeoutMs = 15000;
    
    /**
     * 重试策略类型
     */
    private String retryPolicy = "exponential";
    
    /**
     * 重试次数
     */
    private int retryCount = 3;
    
    /**
     * 重试间隔（毫秒）
     */
    private int retryIntervalMs = 1000;
    
    /**
     * 最大重试间隔（毫秒）
     */
    private int maxRetryIntervalMs = 30000;
    
    /**
     * 命名空间
     */
    private String namespace = "";

    public String getConnectString() { return connectString; }
    public void setConnectString(String connectString) { this.connectString = connectString; }
    public int getSessionTimeoutMs() { return sessionTimeoutMs; }
    public void setSessionTimeoutMs(int sessionTimeoutMs) { this.sessionTimeoutMs = sessionTimeoutMs; }
    public int getConnectionTimeoutMs() { return connectionTimeoutMs; }
    public void setConnectionTimeoutMs(int connectionTimeoutMs) { this.connectionTimeoutMs = connectionTimeoutMs; }
    public String getRetryPolicy() { return retryPolicy; }
    public void setRetryPolicy(String retryPolicy) { this.retryPolicy = retryPolicy; }
    public int getRetryCount() { return retryCount; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }
    public int getRetryIntervalMs() { return retryIntervalMs; }
    public void setRetryIntervalMs(int retryIntervalMs) { this.retryIntervalMs = retryIntervalMs; }
    public int getMaxRetryIntervalMs() { return maxRetryIntervalMs; }
    public void setMaxRetryIntervalMs(int maxRetryIntervalMs) { this.maxRetryIntervalMs = maxRetryIntervalMs; }
    public String getNamespace() { return namespace; }
    public void setNamespace(String namespace) { this.namespace = namespace; }
} 