package com.nowcoder.aop;

import com.nowcoder.ToutiaoApplication;
import com.sun.javafx.fxml.expression.Expression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author KnoWsea
 * @create 2019-02-27 20:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class SimpleAopTest {
    @Test
    public void getProxy(){
        //创建一个MethodInvocation实现类
        MethodInvocation logTask = ()-> System.out.println("logTask start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        //创建一个Advice
        BeforeAdvice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        //为目标对象生成一个代理
        HelloService helloServiceImplProxy = (HelloService)SimpleAop.getProxy(helloServiceImpl, beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
