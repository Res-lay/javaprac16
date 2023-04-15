package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("allControllerMethods())")
    public Object logParams(ProceedingJoinPoint joinPoint) throws Throwable{
        Object retVal = null;
        log.info("Method " + joinPoint.getSignature().getName() + " start");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        retVal = joinPoint.proceed();
        stopWatch.stop();
        log.info("Method finish - " + stopWatch.getTotalTimeMillis() + " ms");
        return retVal;
    }
    @Pointcut("within(com.example.demo.controller.*)")
    public void allControllerMethods(){}
}
