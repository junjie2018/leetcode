package T0001;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(new Solution().twoSum(nums,target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums==null || nums.length < 2){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int key = 0;
        for (int i = 0; i < nums.length; i++) {
            key = target-nums[i];
            if(map.containsKey(key)){
                if(map.get(key)!=i){
                    return new int[]{i,map.get(key)};
                }
            }else {
                map.put(nums[i],i);
            }
        }

        return null;
    }
}
