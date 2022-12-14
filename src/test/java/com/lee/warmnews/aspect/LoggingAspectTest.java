package com.lee.warmnews.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Answers.RETURNS_MOCKS;

@ExtendWith(MockitoExtension.class)
class LoggingAspectTest {

    private final LoggingAspect loggingAspect = new LoggingAspect();

    @Mock(answer = RETURNS_MOCKS)
    private ProceedingJoinPoint pjp;


    @Test
    void proceedShouldBeInvokedWithoutThrowingAnyThrowable() throws Throwable {
        Object expected = new Object();
        Mockito.when(pjp.proceed()).thenReturn(expected);
        Object actual = loggingAspect.aroundAllRepositoryMethodsAdvice(pjp);
        assertSame(expected, actual);
    }

    @Test
    void proceedShouldThrowThrowable() throws Throwable {
        Throwable expected = new Throwable();
        Mockito.when(pjp.proceed()).thenThrow(expected);
        Throwable actual = assertThrows(Throwable.class, () -> loggingAspect.aroundAllRepositoryMethodsAdvice(pjp));
        assertSame(expected, actual);
    }
}