package com.lee.warmnews.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.lee.warmnews.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();

        LOGGER.trace("Execution of {} started", methodName);

        Throwable toThrow = null;
        Object targetMethodResult = null;
        try {
            targetMethodResult = pjp.proceed();
        } catch (Throwable t) {
            toThrow = t;
        }

        LOGGER.trace("Execution of {} completed", methodName);

        if (toThrow != null) {
            throw toThrow;
        }

        return targetMethodResult;
    }
}
