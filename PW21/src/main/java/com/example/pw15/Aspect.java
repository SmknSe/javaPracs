package com.example.pw15;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("allServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();
        Object res = null;
        try {
            res = joinPoint.proceed();
        } catch (Throwable throwable){
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("Method "+joinPoint.getSignature().getName()+" was proceeding in "+(end-start)+" ms");
        return res;
    }

    @Pointcut("within(com.example.pw15.services.*)")
    public void allServiceMethods(){}
}
