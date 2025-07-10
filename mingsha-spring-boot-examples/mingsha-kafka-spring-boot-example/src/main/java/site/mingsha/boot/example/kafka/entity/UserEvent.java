package site.mingsha.boot.example.kafka.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户事件实体
 *
 * @author mingsha
 * @since 1.0.0
 */
@Data
public class UserEvent {
    
    /**
     * 事件ID
     */
    private String eventId;
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 事件类型
     */
    private String eventType;
    
    /**
     * 事件时间戳
     */
    private Long timestamp;
    
    /**
     * 事件数据
     */
    private Map<String, Object> data;
    
    /**
     * 来源IP
     */
    private String sourceIp;
    
    /**
     * 用户代理
     */
    private String userAgent;
    
    /**
     * 会话ID
     */
    private String sessionId;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    public UserEvent() {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }
} 