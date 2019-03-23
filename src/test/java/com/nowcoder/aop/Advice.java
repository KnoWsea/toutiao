package com.nowcoder.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author KnoWsea
 * @create 2019-02-27 20:11
 */
public interface Advice extends InvocationHandler {
}
class BeforeAdvice implements Advice {
    private Object bean;

    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation){
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在目标方法执行前调用通知
        methodInvocation.invoke();
        return method.invoke(bean, args);
    }
}
