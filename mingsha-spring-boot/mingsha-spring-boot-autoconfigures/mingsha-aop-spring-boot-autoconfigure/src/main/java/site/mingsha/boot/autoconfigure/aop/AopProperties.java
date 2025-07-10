package site.mingsha.boot.autoconfigure.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AOP配置属性
 *
 * @author mingsha
 * @date 2025-07-10
 */
@ConfigurationProperties(prefix = "mingsha.aop")
public class AopProperties {

    /**
     * 是否启用AOP自动配置
     */
    private boolean enabled = true;

    /**
     * 是否启用代理目标类
     */
    private boolean proxyTargetClass = true;

    /**
     * 是否启用暴露代理
     */
    private boolean exposeProxy = false;

    /**
     * 切面执行顺序
     */
    private int order = 0;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public boolean isExposeProxy() {
        return exposeProxy;
    }

    public void setExposeProxy(boolean exposeProxy) {
        this.exposeProxy = exposeProxy;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
} 