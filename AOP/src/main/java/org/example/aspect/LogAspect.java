package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LogAspect {

    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Pointcut("execution(* add*(..))")
    public void addPointCut() {
    }

    @Before("addPointCut()")
    public void beforeAddLogic(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSourceLocation());
        System.out.println("About to adding two value");
    }

    @AfterReturning(pointcut = "execution(* add*(..))", returning = "result")
    public void afterReturningAddLogic(JoinPoint joinPoint, Integer result) {
        System.out.println("The result of add two value: " + result.toString());
    }

    @AfterThrowing(pointcut = "addPointCut()", throwing = "exception")
    public void afterThrowingAddLogic(JoinPoint joinPoint, Exception exception) {
        System.out.println("Exception occurs: " + exception.getMessage());
    }

    @After("addPointCut()")
    public void afterAddLogic(JoinPoint joinPoint) {
        System.out.println("Finally add two value is done!");
    }

    @Around("execution(* getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        logger.info("=== Run @Around on method: " + method);
        Long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            logger.warning(e.getMessage());
            result = "There are an exception block the way, so I come up to another way!";
        }
        Long end = System.currentTimeMillis();
        long duration = end - start;

        logger.info("=== Duration: " + duration);
        return result;
    }
}
