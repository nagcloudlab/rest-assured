package com.example.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Before("execution(* transfer(..))")
    public void beforeTransfer(){
        System.out.println("-------------------");
        System.out.println("Before transfer");
        System.out.println("-------------------");
    }
}
