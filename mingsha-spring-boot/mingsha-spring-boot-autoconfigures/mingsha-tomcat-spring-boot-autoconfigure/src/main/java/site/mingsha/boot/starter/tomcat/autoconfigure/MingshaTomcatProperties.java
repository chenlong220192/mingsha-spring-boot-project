package site.mingsha.boot.starter.tomcat.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "server.tomcat")
public class MingshaTomcatProperties {

    /**
     * 连接超时时间（毫秒）
     */
    private int connectionTimeout = 20000;

    /**
     * 最大连接数
     */
    private int maxConnections = 8192;

    /**
     * 接受队列大小
     */
    private int acceptCount = 100;

    /**
     * 最大线程数
     */
    private int maxThreads = 200;

    /**
     * 最小空闲线程数
     */
    private int minSpareThreads = 10;

    // Getters and Setters
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getAcceptCount() {
        return acceptCount;
    }

    public void setAcceptCount(int acceptCount) {
        this.acceptCount = acceptCount;
    }

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public int getMinSpareThreads() {
        return minSpareThreads;
    }

    public void setMinSpareThreads(int minSpareThreads) {
        this.minSpareThreads = minSpareThreads;
    }
} 