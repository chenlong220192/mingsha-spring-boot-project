package site.mingsha.boot.example.kafka.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

/**
 * 消息请求DTO
 *
 * @author mingsha
 * @since 1.0.0
 */
@Data
public class MessageRequest {
    
    /**
     * 主题
     */
    @NotBlank(message = "主题不能为空")
    private String topic;
    
    /**
     * 消息键
     */
    private String key;
    
    /**
     * 消息内容
     */
    @NotBlank(message = "消息内容不能为空")
    private String message;
} 