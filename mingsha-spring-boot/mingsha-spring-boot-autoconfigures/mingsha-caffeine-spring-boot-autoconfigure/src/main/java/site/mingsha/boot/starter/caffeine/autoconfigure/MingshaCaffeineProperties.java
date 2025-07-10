package site.mingsha.boot.starter.caffeine.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha Caffeine 配置属性
 */
@ConfigurationProperties(prefix = "spring.cache.caffeine")
public class MingshaCaffeineProperties {
    /**
     * 最大缓存条目数
     */
    private Long maxSize = 1000L;
    /**
     * 写入后过期时间（秒）
     */
    private Long expireAfterWrite = 600L;
    /**
     * 访问后过期时间（秒）
     */
    private Long expireAfterAccess = 300L;
    /**
     * 写入后刷新时间（秒）
     */
    private Long refreshAfterWrite = 300L;
    /**
     * 是否记录统计信息
     */
    private Boolean recordStats = true;

    public Long getMaxSize() { return maxSize; }
    public void setMaxSize(Long maxSize) { this.maxSize = maxSize; }
    public Long getExpireAfterWrite() { return expireAfterWrite; }
    public void setExpireAfterWrite(Long expireAfterWrite) { this.expireAfterWrite = expireAfterWrite; }
    public Long getExpireAfterAccess() { return expireAfterAccess; }
    public void setExpireAfterAccess(Long expireAfterAccess) { this.expireAfterAccess = expireAfterAccess; }
    public Long getRefreshAfterWrite() { return refreshAfterWrite; }
    public void setRefreshAfterWrite(Long refreshAfterWrite) { this.refreshAfterWrite = refreshAfterWrite; }
    public Boolean getRecordStats() { return recordStats; }
    public void setRecordStats(Boolean recordStats) { this.recordStats = recordStats; }
} 