package ru.online.t1_academy.projectT1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.online.t1_academy.projectT1.example.NullTaskException;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("@annotation(ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("LOG BEFORE executing method " + joinPoint.getSignature());
    }

    @AfterReturning("@annotation(ru.online.t1_academy.projectT1.aspect.annotation.CustomLogging)")
    public void logAfterReturning(JoinPoint joinPoint) {
        log.info("LOG AFTER executing method " + joinPoint.getSignature());
    }

    @AfterThrowing(
            pointcut = "@annotation(ru.online.t1_academy.projectT1.aspect.annotation.ExampleAnnotation)",
            throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, NullTaskException exception) {
        log.error("LOG ERROR executing method " + joinPoint.getSignature() +"\n"+
                  "cause " + exception.getMessage());
    }
}
