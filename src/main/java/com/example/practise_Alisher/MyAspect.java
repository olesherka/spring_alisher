package com.example.practise_Alisher;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Before("execution(* com.example.practise_Alisher.service.ServiceC.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore called. Method name: " + joinPoint.getSignature().toShortString());

    }
    @After("execution(* com.example.practise_Alisher.service.ServiceC.*(..))")
    public void logAfter(JoinPoint joinPoint){
        log.info("After called. Method name: " + joinPoint.getSignature().toShortString());
    }
    @Pointcut("execution(* com.example.practise_Alisher.service..*(..))")
    protected void loggingOperation(){

    }
    @Around("execution(* com.example.practise_Alisher.service..*(..))")
    public void logAround(JoinPoint joinPoint) {
        System.out.println("Around method getting called");
    }

    @AfterReturning("loggingOperation()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("AfterReturning. Method name: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing("loggingOperation()")
    public void AfterReturning(JoinPoint joinPoint){
        log.info("AfterReturning. Method name: " + joinPoint.getSignature().toShortString());
    }


}