package site.mingsha.boot.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面 - 记录方法调用
 *
 * @author mingsha
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* site.mingsha.boot.example.aop.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("[AOP日志] 方法开始: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterMethod(JoinPoint joinPoint, Object result) {
        System.out.println("[AOP日志] 方法结束: " + joinPoint.getSignature() + ", 返回: " + result);
    }
} 