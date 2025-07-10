package site.mingsha.boot.autoconfigure.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MongoDB配置属性
 *
 * @author mingsha
 * @date 2025-07-10
 */
@ConfigurationProperties(prefix = "mingsha.mongodb")
public class MongoProperties {

    /**
     * 是否启用MongoDB自动配置
     */
    private boolean enabled = true;

    /**
     * MongoDB连接URI
     */
    private String uri = "mongodb://localhost:27017";

    /**
     * 数据库名称
     */
    private String database = "test";

    /**
     * 连接超时时间（毫秒）
     */
    private int connectTimeout = 10000;

    /**
     * 读取超时时间（毫秒）
     */
    private int readTimeout = 30000;

    /**
     * 最大连接数
     */
    private int maxConnections = 100;

    /**
     * 最小连接数
     */
    private int minConnections = 5;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }
} 