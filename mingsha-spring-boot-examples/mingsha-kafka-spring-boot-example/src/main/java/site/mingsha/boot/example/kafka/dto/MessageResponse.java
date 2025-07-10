package site.mingsha.boot.example.kafka.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 消息响应DTO
 *
 * @author mingsha
 * @since 1.0.0
 */
@Data
public class MessageResponse {
    
    /**
     * 是否成功
     */
    private boolean success;
    
    /**
     * 消息
     */
    private String message;
    
    /**
     * 数据
     */
    private Object data;
    
    /**
     * 时间戳
     */
    private LocalDateTime timestamp;
    
    public MessageResponse() {
        this.timestamp = LocalDateTime.now();
    }
    
    public MessageResponse(boolean success, String message) {
        this();
        this.success = success;
        this.message = message;
    }
    
    public MessageResponse(boolean success, String message, Object data) {
        this(success, message);
        this.data = data;
    }
    
    /**
     * 成功响应
     */
    public static MessageResponse success(String message) {
        return new MessageResponse(true, message);
    }
    
    /**
     * 成功响应（带数据）
     */
    public static MessageResponse success(String message, Object data) {
        return new MessageResponse(true, message, data);
    }
    
    /**
     * 错误响应
     */
    public static MessageResponse error(String message) {
        return new MessageResponse(false, message);
    }
} 