package com.stackroute.springmongodb.aspect;

import com.stackroute.springmongodb.domain.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //Creating a logger object
    private Logger logger = LoggerFactory.getLogger("LoggingAspect.class");

    //Action you want to take & at what point
    // .* fro all the methods whether public,private,default etc.
    //(..) any no. of parameteres
    // point cut is basically the regex we have written here
    @Before(value = "execution(* com.stackroute.springmongodb.controller.EmployeeController .*(..))")
    public  void beforeAdvicemethod(JoinPoint joinPoint){
        logger.info("Inside the before advice");
        logger.info("Target method object--->" + joinPoint.getSignature().getName());

    }

    @After(value = "execution(* com.stackroute.springmongodb.controller.EmployeeController .*(..)) && args(employee)")
    public  void afterAdvicemethod(JoinPoint joinPoint, Employee employee){
        logger.info("Inside the after advice");
        logger.info("Target method object--->" + joinPoint.getSignature().getName());
        logger.info("Object with the following data will be persisted " + employee);
    }

    @AfterReturning(value = "execution(* com.stackroute.springmongodb.controller.EmployeeController .*(..))" , returning = "retval")
    public void afterReturningAdvice(JoinPoint joinPoint , Object retval) {
        logger.info("Inside the afterReturn  advice");
        logger.info("Target method object --->" + joinPoint.getSignature().getName());
        logger.info("Object with following data will be persisted " + retval);
    }

    @Pointcut(value = "execution(* com.stackroute.springmongodb.service.EmployeeServiceImpl.*(..))")
    private void logAfterException(){}

    @AfterThrowing(value = "logAfterException()" , throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint , Exception exception){
        logger.error("Inside after throwing");
        logger.error("Target method object ---->" + joinPoint.getSignature().getName());
        logger.error("Exception thrown " + exception.getMessage());

    }

}

