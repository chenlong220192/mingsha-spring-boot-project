package site.mingsha.boot.starter.mail.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha Mail 配置属性
 */
@ConfigurationProperties(prefix = "spring.mail")
public class MingshaMailProperties {
    /**
     * SMTP服务器地址
     */
    private String host = "localhost";
    
    /**
     * SMTP服务器端口
     */
    private int port = 25;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 协议
     */
    private String protocol = "smtp";
    
    /**
     * 是否启用SSL
     */
    private boolean ssl = false;
    
    /**
     * 是否启用TLS
     */
    private boolean tls = false;
    
    /**
     * 连接超时时间（毫秒）
     */
    private int connectionTimeout = 5000;
    
    /**
     * 读取超时时间（毫秒）
     */
    private int readTimeout = 5000;
    
    /**
     * 写入超时时间（毫秒）
     */
    private int writeTimeout = 5000;
    
    /**
     * 默认编码
     */
    private String defaultEncoding = "UTF-8";

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }
    public boolean isSsl() { return ssl; }
    public void setSsl(boolean ssl) { this.ssl = ssl; }
    public boolean isTls() { return tls; }
    public void setTls(boolean tls) { this.tls = tls; }
    public int getConnectionTimeout() { return connectionTimeout; }
    public void setConnectionTimeout(int connectionTimeout) { this.connectionTimeout = connectionTimeout; }
    public int getReadTimeout() { return readTimeout; }
    public void setReadTimeout(int readTimeout) { this.readTimeout = readTimeout; }
    public int getWriteTimeout() { return writeTimeout; }
    public void setWriteTimeout(int writeTimeout) { this.writeTimeout = writeTimeout; }
    public String getDefaultEncoding() { return defaultEncoding; }
    public void setDefaultEncoding(String defaultEncoding) { this.defaultEncoding = defaultEncoding; }
} 