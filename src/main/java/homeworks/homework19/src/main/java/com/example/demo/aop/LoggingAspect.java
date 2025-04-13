package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut (value = "@annotation(Logs)")
    public void callLoggingAround() {}



    @Around(value = "callLoggingAround()")
    public Object LoggingAround(ProceedingJoinPoint pjp) throws Throwable {

        log.info("выполнения метода pjp.getTarget() = {} " ,  pjp.getTarget());

        log.info("выполнения метода pjp.getStaticPart().toShortString() = {} " ,  pjp.getStaticPart().toShortString());

        return pjp.proceed();
    }
}