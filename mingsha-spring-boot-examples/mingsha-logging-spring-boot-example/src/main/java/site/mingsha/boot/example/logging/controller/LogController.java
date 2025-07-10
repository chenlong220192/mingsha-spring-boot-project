package site.mingsha.boot.example.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 日志控制器 - 演示日志功能
 */
@RestController
@RequestMapping("/api/logs")
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     * 记录不同级别的日志
     */
    @PostMapping("/record")
    public ResponseEntity<String> recordLog(@RequestParam String level,
                                           @RequestParam String message) {
        switch (level.toLowerCase()) {
            case "debug":
                logger.debug("DEBUG日志: {}", message);
                break;
            case "info":
                logger.info("INFO日志: {}", message);
                break;
            case "warn":
                logger.warn("WARN日志: {}", message);
                break;
            case "error":
                logger.error("ERROR日志: {}", message);
                break;
            default:
                logger.info("默认INFO日志: {}", message);
        }
        return ResponseEntity.ok("日志记录成功: " + level + " - " + message);
    }

    /**
     * 记录异常日志
     */
    @PostMapping("/exception")
    public ResponseEntity<String> recordException(@RequestParam String message) {
        try {
            throw new RuntimeException("模拟异常: " + message);
        } catch (Exception e) {
            logger.error("捕获到异常: {}", e.getMessage(), e);
        }
        return ResponseEntity.ok("异常日志记录成功");
    }

    /**
     * 记录结构化日志
     */
    @PostMapping("/structured")
    public ResponseEntity<String> recordStructuredLog(@RequestParam String userId,
                                                     @RequestParam String action) {
        logger.info("用户操作 - 用户ID: {}, 操作: {}, 时间: {}", 
                   userId, action, System.currentTimeMillis());
        return ResponseEntity.ok("结构化日志记录成功");
    }
} 