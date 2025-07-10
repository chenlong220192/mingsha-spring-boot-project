package site.mingsha.boot.starter.elasticsearch.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha Elasticsearch 配置属性
 */
@ConfigurationProperties(prefix = "spring.elasticsearch")
public class MingshaElasticsearchProperties {
    /**
     * Elasticsearch服务器地址
     */
    private String host = "localhost";
    
    /**
     * Elasticsearch服务器端口
     */
    private int port = 9200;
    
    /**
     * 连接超时时间（毫秒）
     */
    private int connectTimeout = 5000;
    
    /**
     * 读取超时时间（毫秒）
     */
    private int readTimeout = 60000;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 是否启用SSL
     */
    private boolean ssl = false;
    
    /**
     * 索引名称前缀
     */
    private String indexPrefix = "";

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public int getConnectTimeout() { return connectTimeout; }
    public void setConnectTimeout(int connectTimeout) { this.connectTimeout = connectTimeout; }
    public int getReadTimeout() { return readTimeout; }
    public void setReadTimeout(int readTimeout) { this.readTimeout = readTimeout; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public boolean isSsl() { return ssl; }
    public void setSsl(boolean ssl) { this.ssl = ssl; }
    public String getIndexPrefix() { return indexPrefix; }
    public void setIndexPrefix(String indexPrefix) { this.indexPrefix = indexPrefix; }
} 