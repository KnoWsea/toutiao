package com.nowcoder.test;

import java.util.*;

/**
 * @author KnoWsea
 * @create 2019-03-14 19:30
 */

public class test2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            long digit = s.nextLong();
            int n = s.nextInt();
            System.out.println(getMax(digit, n));
        }
    }

    public static long getMax(long digit, int n) {
        String d = String.valueOf(digit);
        char[] ch = d.toCharArray();
        //定义一个list用来表示digit的最大数。比如假设ch为{615253}则list为（655321）
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            list.add(ch[i]);
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                    return o2 - o1;
            }
        });
        //对照list来修改ch数组元素的位置，
        for (int i = 0, j = 0; j < n && i < ch.length; j++) {
            //跳过前面相等的元素。
            while (i < ch.length && list.get(i) == ch[i])
                ++i;
            if(i < ch.length) {
                //从ch后面查找和list[i]相同的元素，并交换，保证每次交换最大。
                for(int t = ch.length - 1; t > i ; t--){
                    if(ch[t] == list.get(i)) {
                        char temp = ch[i];
                        ch[i] = ch[t];
                        ch[t] = temp;
                        break;
                    }
                }
            }
        }
        String s = new String(ch);
        return Long.valueOf(s);
    }
}
