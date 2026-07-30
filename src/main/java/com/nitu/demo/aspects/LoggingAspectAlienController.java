package com.nitu.demo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAlienController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectAlienController.class);

    @Before("execution(public * com.nitu.demo.controllers.AlienController.getAliens())")
    public void getAliensBeforeLog(){
        logger.info("GetAliens() method called!");
    }

    // This method is gonna run irrespective of the exceptions
    @After("execution(public * com.nitu.demo.controllers.AlienController.getAliens())")
    public void getAliensAfterLog(){
        logger.info("GetAliens() method Executed!");
    }

    @AfterReturning("execution(public * com.nitu.demo.controllers.AlienController.getAliens())")
    public void getAliensAfterLogSuccess(){
        logger.info("GetAliens() method successfully Executed!");
    }




}
