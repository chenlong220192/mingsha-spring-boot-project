package site.mingsha.boot.example.kafka.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

/**
 * 用户事件请求DTO
 *
 * @author mingsha
 * @since 1.0.0
 */
@Data
public class UserEventRequest {
    
    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空")
    private String userId;
    
    /**
     * 事件类型
     */
    @NotBlank(message = "事件类型不能为空")
    private String eventType;
    
    /**
     * 事件时间戳
     */
    @NotNull(message = "事件时间戳不能为空")
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
} 