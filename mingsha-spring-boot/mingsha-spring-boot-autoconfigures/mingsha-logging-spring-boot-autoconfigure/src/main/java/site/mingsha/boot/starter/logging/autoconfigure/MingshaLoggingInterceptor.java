package site.mingsha.boot.starter.logging.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Mingsha Logging 拦截器
 *
 * @author mingsha
 * @since 1.0.0
 */
public class MingshaLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MingshaLoggingInterceptor.class);

    private boolean includeHeaders = true;
    private boolean includeBody = false;
    private int maxBodyLength = 1024;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (logger.isDebugEnabled()) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("Request: ").append(request.getMethod()).append(" ").append(request.getRequestURI());
            
            if (includeHeaders) {
                logMessage.append("\nHeaders:");
                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();
                    String headerValue = request.getHeader(headerName);
                    logMessage.append("\n  ").append(headerName).append(": ").append(headerValue);
                }
            }
            
            logger.debug(logMessage.toString());
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (logger.isDebugEnabled()) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("Response: ").append(response.getStatus()).append(" ").append(request.getRequestURI());
            
            if (includeHeaders) {
                logMessage.append("\nResponse Headers:");
                for (String headerName : response.getHeaderNames()) {
                    String headerValue = response.getHeader(headerName);
                    logMessage.append("\n  ").append(headerName).append(": ").append(headerValue);
                }
            }
            
            if (ex != null) {
                logMessage.append("\nException: ").append(ex.getMessage());
            }
            
            logger.debug(logMessage.toString());
        }
    }

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