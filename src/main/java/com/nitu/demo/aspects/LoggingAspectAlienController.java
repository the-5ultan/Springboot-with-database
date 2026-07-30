package com.nitu.demo.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAlienController {

    @Before("execution(public * com.nitu.demo.controllers.AlienController.getAliens())")
    public void getAliensBeforeLog(){
        System.out.println("GetAliens() method called !");
    }

    @After("execution(public * com.nitu.demo.controllers.AlienController.getAliens())")
    public void getAliensAfterLog(){
        System.out.println("GetAliens() method Executed !");
    }


}
