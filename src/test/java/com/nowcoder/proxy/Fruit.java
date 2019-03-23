package com.nowcoder.proxy;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;
import org.springframework.jdbc.core.SqlReturnResultSet;
import sun.java2d.pipe.SpanIterator;

import javax.servlet.Registration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author KnoWsea
 * @create 2019-02-27 21:28
 */
public interface Fruit {
    void show();
}

class Apple implements Fruit{
    @Override
    public void show() {
        System.out.println("this is an apple");
    }
}

class Banana implements Fruit{
    @Override
    public void show() {
        System.out.println("this is a banana");
    }
}

class DynamicProxy{
    static class MyHandler implements InvocationHandler{

        private Object proxy;

        public MyHandler(Object proxy){
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("在invoke之前");;
            Object result = method.invoke(this.proxy, args);
            System.out.println("在invoke之后");
            return result;
        }
    }

}
class test{
    public static void main(String[] args) {
        Fruit fruit = (Fruit) Proxy.newProxyInstance(test.class.getClassLoader(), Banana.class.getInterfaces(), new DynamicProxy.MyHandler(new Banana()));
        fruit.show();
        System.out.println(fruit instanceof Proxy);
        System.out.println(fruit.getClass());
    }
}

class CglibAgent implements MethodInterceptor{

    private Object proxy;
    public Object getInstance(Object proxy){
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("invokeSuper之前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("invokeSuper之后");
        return result;
    }

    public static void main(String[] args) {
        CglibAgent agent = new CglibAgent();
        Apple apple = (Apple) agent.getInstance(new Apple());
        apple.show();
        System.out.println(apple.getClass());
    }
}