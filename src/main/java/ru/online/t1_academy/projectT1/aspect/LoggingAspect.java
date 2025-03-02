package ru.online.t1_academy.projectT1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("@annotation(ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("LOG BEFORE executing method {}", joinPoint.getSignature());
    }

    @AfterReturning("@annotation(ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging)")
    public void logAfterReturning(JoinPoint joinPoint) {
        log.info("LOG AFTER executing method {}", joinPoint.getSignature());
    }
}
