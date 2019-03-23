package com.nowcoder.aop;

import java.lang.reflect.Proxy;

/**
 * 生成代理类
 * @author KnoWsea
 * @create 2019-02-27 20:19
 */
public class SimpleAop {
    public static Object getProxy(Object bean, Advice advice){
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader()
                , bean.getClass().getInterfaces(), advice);
    }
}
