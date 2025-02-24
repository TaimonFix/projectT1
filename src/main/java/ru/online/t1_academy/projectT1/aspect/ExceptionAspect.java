package ru.online.t1_academy.projectT1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.online.t1_academy.projectT1.exception.NullTaskException;

@Component
@Aspect
@Slf4j
public class ExceptionAspect {

    @AfterThrowing(
            pointcut = "@annotation(ru.online.t1_academy.projectT1.aspect.annotation.ExceptionAnnotation)",
            throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, NullTaskException exception) {
        log.error("LOG ERROR executing method {}, cause: {}", joinPoint.getSignature(), exception.getMessage());
    }
}
