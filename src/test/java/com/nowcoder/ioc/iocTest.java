package com.nowcoder.ioc;

import com.nowcoder.ToutiaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author KnoWsea
 * @create 2019-02-27 16:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class iocTest {
    @Test
    public void getBean() throws Exception {
        String location = SimpleIoc.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIoc ioc = new SimpleIoc(location);
        Wheel wheel = (Wheel)ioc.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car)ioc.getBean("car");
        System.out.println(car);
    }

}
