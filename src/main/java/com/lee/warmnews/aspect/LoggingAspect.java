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

    private final static String EXECUTION_OF_XXX_STARTED = "Execution of {} started";
    private final static String EXECUTION_OF_XXX_COMPLETED = "Execution of {} completed";

    @Around("execution(* com.lee.warmnews.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();

        LOGGER.trace(EXECUTION_OF_XXX_STARTED, methodName);

        Throwable toThrow = null;
        Object targetMethodResult = null;
        try {
            targetMethodResult = pjp.proceed();
        } catch (Throwable t) {
            toThrow = t;
        }

        LOGGER.trace(EXECUTION_OF_XXX_COMPLETED, methodName);

        if (toThrow != null) {
            throw toThrow;
        }

        return targetMethodResult;
    }
}
