package com.nowcoder.aop;

/**
 * @author KnoWsea
 * @create 2019-02-27 20:25
 */
public interface HelloService {
    void sayHelloWorld();
}

class HelloServiceImpl implements HelloService{
    @Override
    public void sayHelloWorld() {
        System.out.println("hello world");
    }
}
