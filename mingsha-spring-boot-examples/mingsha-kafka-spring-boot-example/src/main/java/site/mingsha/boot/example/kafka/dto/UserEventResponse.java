package site.mingsha.boot.example.kafka.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户事件响应DTO
 *
 * @author mingsha
 * @since 1.0.0
 */
@Data
public class UserEventResponse {
    
    /**
     * 是否成功
     */
    private boolean success;
    
    /**
     * 消息
     */
    private String message;
    
    /**
     * 事件ID
     */
    private String eventId;
    
    /**
     * 时间戳
     */
    private LocalDateTime timestamp;
    
    public UserEventResponse() {
        this.timestamp = LocalDateTime.now();
    }
    
    public UserEventResponse(boolean success, String message) {
        this();
        this.success = success;
        this.message = message;
    }
    
    public UserEventResponse(boolean success, String message, String eventId) {
        this(success, message);
        this.eventId = eventId;
    }
    
    /**
     * 成功响应
     */
    public static UserEventResponse success(String message) {
        return new UserEventResponse(true, message);
    }
    
    /**
     * 成功响应（带事件ID）
     */
    public static UserEventResponse success(String message, String eventId) {
        return new UserEventResponse(true, message, eventId);
    }
    
    /**
     * 错误响应
     */
    public static UserEventResponse error(String message) {
        return new UserEventResponse(false, message);
    }
} 