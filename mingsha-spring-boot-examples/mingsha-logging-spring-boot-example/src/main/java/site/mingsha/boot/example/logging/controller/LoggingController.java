package site.mingsha.boot.example.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Logging 示例控制器
 *
 * @author mingsha
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/logging")
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/test")
    public Map<String, Object> testLogging() {
        logger.debug("Debug message from LoggingController");
        logger.info("Info message from LoggingController");
        logger.warn("Warn message from LoggingController");
        logger.error("Error message from LoggingController");

        Map<String, Object> result = new HashMap<>();
        result.put("message", "Logging test completed");
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

    @PostMapping("/test")
    public Map<String, Object> testPostLogging(@RequestBody Map<String, Object> request) {
        logger.info("Received POST request with data: {}", request);

        Map<String, Object> result = new HashMap<>();
        result.put("message", "POST request processed");
        result.put("receivedData", request);
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

    @GetMapping("/level/{level}")
    public Map<String, Object> testLogLevel(@PathVariable String level) {
        switch (level.toUpperCase()) {
            case "DEBUG":
                logger.debug("This is a DEBUG level message");
                break;
            case "INFO":
                logger.info("This is an INFO level message");
                break;
            case "WARN":
                logger.warn("This is a WARN level message");
                break;
            case "ERROR":
                logger.error("This is an ERROR level message");
                break;
            default:
                logger.info("Unknown log level: {}", level);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("message", "Log level test completed");
        result.put("level", level);
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }
} 