package site.mingsha.boot.example.kafka.service;

import site.mingsha.boot.example.kafka.entity.UserEvent;

/**
 * 用户事件处理服务接口
 *
 * @author mingsha
 * @since 1.0.0
 */
public interface UserEventProcessService {
    
    /**
     * 处理用户事件
     *
     * @param userEvent 用户事件
     */
    void processUserEvent(UserEvent userEvent);
    
    /**
     * 处理用户登录事件
     *
     * @param userEvent 用户事件
     */
    void processUserLogin(UserEvent userEvent);
    
    /**
     * 处理用户注册事件
     *
     * @param userEvent 用户事件
     */
    void processUserRegister(UserEvent userEvent);
    
    /**
     * 处理用户注销事件
     *
     * @param userEvent 用户事件
     */
    void processUserLogout(UserEvent userEvent);
    
    /**
     * 处理用户行为事件
     *
     * @param userEvent 用户事件
     */
    void processUserAction(UserEvent userEvent);
} 