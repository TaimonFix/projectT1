package ru.online.t1_academy.projectT1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.online.t1_academy.projectT1.exception.NullTaskException;

@Component
@Aspect
@Slf4j
public class TrackingAspect {

    @Around("@annotation(ru.online.t1_academy.projectT1.aspect.annotation.TrackingAnnotation)")
    public Object trackingAdvice(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object proceeded;
        try {
            proceeded = joinPoint.proceed();
        } catch (Throwable e) {
            throw new NullTaskException(e.getMessage());
        }
        long finish = System.currentTimeMillis();

        log.info("Time execution method {} cost time: {}", joinPoint.getSignature().getName(), (finish - start));

        return proceeded;
    }
}
