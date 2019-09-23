package com.haizhi.nettyclient.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
    @Before("execution(* com.haizhi.nettyclient.NettyClientApplicationTests.contextLoads(..))")
    public void before(){
        System.err.print("Aspect before");
    }
}
