package com.summer.springboot.logger;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    public final static Gson GSON = new Gson();

    public final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.summer.springboot.controller..*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void before(JoinPoint joinPoint){
        logger.warn("-----------------------------------------start-----------------------------------------------------");
        logger.warn("| requst time    : {}",System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.warn("| URL            : {}", request.getRequestURL().toString());
        logger.warn("| HTTP Method    : {}", request.getMethod());
        logger.warn("| Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.warn("| IP             : {}", request.getRemoteAddr());
        logger.warn("| Request Args   : {}", GSON.toJson(joinPoint.getArgs()));
    }

    @After("log()")
    public void after(){
        logger.warn("-------------------------------------------end-----------------------------------------------------");
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        logger.warn("| Response Args  : {}", new Gson().toJson(result));
        logger.warn("| Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}
