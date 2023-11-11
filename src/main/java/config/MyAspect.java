package config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Before("execution(* com.example.practise_Alisher.service.ServiceD.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore called.");
    }
    @AfterThrowing("execution(* com.example.practise_Alisher.service..*(..))")
    public void logAfterThrow(JoinPoint joinPoint){
        log.info("logAfterThrowing called.");
    }
    @AfterReturning("execution(* com.example.practise_Alisher.service..*(..))")
    public void logAfterReturn(JoinPoint joinPoint){
        log.info("logAfterReturning called.");
    }
    @After("execution(* com.example.practise_Alisher.service..*(..))")
    public void logAfter(JoinPoint joinPoint){
        log.info("logAfter called.");
    }
}