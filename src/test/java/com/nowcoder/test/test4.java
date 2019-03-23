package com.nowcoder.test;

import com.nowcoder.util.JedisAdapter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author KnoWsea
 * @create 2019-03-22 15:14
 */
public class test4 {

    @Autowired
    private JedisAdapter jedisAdapter;

    public List<String> test() {
        jedisAdapter.lpush("key", "dsfs");
        jedisAdapter.lpush("key", "dsfssfef");
        jedisAdapter.lpush("key", "dsesffs");
        jedisAdapter.lpush("key", "ww");
        return jedisAdapter.brpop(0, "key");
    }
}
@SpringBootApplication
class test5{
    @Test
    public void main() {
        test4 test4 = new test4();
        System.out.println(test4.test());
    }
}