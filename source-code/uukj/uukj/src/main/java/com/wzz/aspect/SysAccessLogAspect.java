package com.wzz.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @ClassName SysAccessLogAspect
 * @Description TODO 系统访问日志切面类
 * @Author wangZhenZhong
 * Version 1.0
 **/
@Component
public class SysAccessLogAspect {

    public void doBefore(JoinPoint jp){
        System.out.println("前置通知执行啦");
    }

    public void doAfter(JoinPoint jp){
        System.out.println("后置通知执行啦");
    }
}
