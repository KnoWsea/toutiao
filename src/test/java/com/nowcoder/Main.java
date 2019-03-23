package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author KnoWsea
 * @create 2019-03-15 19:37
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素和前一个相同,则跳过,因为已经找出符合条件的元素了.
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(3, Integer.MAX_VALUE);
            while(left < right){
                ArrayList<Integer> a = new ArrayList<>();
                if((nums[left] + nums[right]) == sum){
                    if(!map.containsValue(nums[left])) {
                        map.put(1,nums[left]);
                        map.put(2,nums[right]);
                        a.add(nums[i]);
                        a.add(nums[left]);
                        a.add(nums[right]);
                        list.add(a);
                    }
                    left++;
                    right--;
                }else if((nums[left] + nums[right]) > sum){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return list;
    }
}

