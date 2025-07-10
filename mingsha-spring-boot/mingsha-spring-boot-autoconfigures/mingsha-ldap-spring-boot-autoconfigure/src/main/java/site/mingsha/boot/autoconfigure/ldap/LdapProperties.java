package site.mingsha.boot.autoconfigure.ldap;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * LDAP配置属性
 *
 * @author mingsha
 * @date 2025-07-10
 */
@ConfigurationProperties(prefix = "mingsha.ldap")
public class LdapProperties {

    /**
     * 是否启用LDAP自动配置
     */
    private boolean enabled = true;

    /**
     * LDAP服务器地址
     */
    private String url = "ldap://localhost:389";

    /**
     * 基础DN
     */
    private String base = "dc=example,dc=com";

    /**
     * 管理员DN
     */
    private String managerDn;

    /**
     * 管理员密码
     */
    private String managerPassword;

    /**
     * 连接超时时间（毫秒）
     */
    private int connectTimeout = 3000;

    /**
     * 读取超时时间（毫秒）
     */
    private int readTimeout = 3000;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getManagerDn() {
        return managerDn;
    }

    public void setManagerDn(String managerDn) {
        this.managerDn = managerDn;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
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
} 