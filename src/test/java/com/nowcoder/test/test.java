package com.nowcoder.test;

import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author KnoWsea
 * @create 2019-03-14 19:00
 */
public class test extends AbstractQueuedSynchronizer {



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ds = s.nextInt();
        int zs = s.nextInt();
        int res = 1;
        boolean flag = true;
        if (zs == 0) {
            System.out.println(1);
        }
        if (zs < 0) {
            flag = false;
            zs = -zs;
        }
        int index = ds;
        while (zs != 0) {
            if ((zs & 1) == 1) {
                res *= index;
            }
            zs = zs >> 1;
            index *= index;
        }
        System.out.println(flag ? res : 1.0 / res);
    }
}

