package com.nowcoder.test;

import java.util.Scanner;

/**
 * @author KnoWsea
 * @create 2019-03-14 19:35
 */
public class test3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = {1, 3, 4, 5, 9, 12, 11, 14, 17};
        int left = 0;
        for(int i = 0; left == 0; i++){
            for(int m = i + 1; m < a.length; m++){
                if(a[i] > a[m]){
                    left = i;
                    break;
                }
            }
        }
        int right = 0;
        for(int j = a.length - 1; right == 0;j--){
            for(int m = j - 1; m >= 0; m--){
                if(a[j] < a[m]){
                    right = j;
                    break;
                }
            }
        }
        System.out.println(right - left + 1);
    }
}
