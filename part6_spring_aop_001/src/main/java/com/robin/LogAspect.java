package com.robin;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by robin on 2017/8/21.
 */

@Aspect
public class LogAspect {
    @Before("xxservice")
    public void beforeMethod(){

    }
}
