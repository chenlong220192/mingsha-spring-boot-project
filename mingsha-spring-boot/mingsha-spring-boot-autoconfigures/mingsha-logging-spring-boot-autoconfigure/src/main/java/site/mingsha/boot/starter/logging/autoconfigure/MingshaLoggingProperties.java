package site.mingsha.boot.starter.logging.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha Logging 配置属性
 *
 * @author mingsha
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "logging")
public class MingshaLoggingProperties {

    /**
     * 是否启用 Mingsha Logging 拦截器
     */
    private boolean interceptorEnabled = true;

    /**
     * 拦截器配置
     */
    private Interceptor interceptor = new Interceptor();

    public boolean isInterceptorEnabled() {
        return interceptorEnabled;
    }

    public void setInterceptorEnabled(boolean interceptorEnabled) {
        this.interceptorEnabled = interceptorEnabled;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    /**
     * 拦截器配置
     */
    public static class Interceptor {

        /**
         * 是否包含请求头
         */
        private boolean includeHeaders = true;

        /**
         * 是否包含请求体
         */
        private boolean includeBody = false;

        /**
         * 请求体最大长度
         */
        private int maxBodyLength = 1024;

        public boolean isIncludeHeaders() {
            return includeHeaders;
        }

        public void setIncludeHeaders(boolean includeHeaders) {
            this.includeHeaders = includeHeaders;
        }

        public boolean isIncludeBody() {
            return includeBody;
        }

        public void setIncludeBody(boolean includeBody) {
            this.includeBody = includeBody;
        }

        public int getMaxBodyLength() {
            return maxBodyLength;
        }

        public void setMaxBodyLength(int maxBodyLength) {
            this.maxBodyLength = maxBodyLength;
        }
    }
} 