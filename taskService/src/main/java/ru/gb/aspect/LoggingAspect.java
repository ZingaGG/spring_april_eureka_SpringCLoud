package ru.gb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(TrackUserAction)")
    public void log(){}

    @Around("log()")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " начал работу!");

        Object returnedByMethod = joinPoint.proceed();

        System.out.println(methodName + " успешно отработал!");

        return returnedByMethod;
    }
}
