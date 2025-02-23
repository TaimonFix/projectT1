package ru.online.t1_academy.projectT1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("@annotation(ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("LOG BEFORE executing method " + joinPoint.getSignature());
    }
}
