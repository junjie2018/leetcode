package T0015;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().threeSum(new int[]{0,0,0});
        System.out.println(result.toString());
    }
}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int base = 0;
        while (base < nums.length - 2 && nums[base] <= 0) {

            int left = base + 1;
            int right = nums.length - 1;
            int target = 0 - nums[base];

            while(left < right && nums[right]>=0){
                int sum = nums[left] + nums[right];

                if(sum > target){
                    right = moveRight(nums,right);
                }else if(sum < target){
                    left = moveLeft(nums,left);
                }else {
                    result.add(Arrays.asList(nums[base], nums[left], nums[right]));
                    right = moveRight(nums,right);
                    left = moveLeft(nums,left);
                }
            }

            base = moveBase(nums,base);
        }
        return result;
    }

    private int moveBase(int[] nums,int base){
        do{
            base++;
        }while (base<nums.length-1 && nums[base] == nums[base-1]);
        return base;
    }

    private int moveRight(int[] nums, int right){
        do{
            right--;
        }while (right>0 && nums[right] == nums[right+1]);
        return right;
    }

    private int moveLeft(int[] nums, int left){
        do{
            left++;
        }while (left<nums.length-1 && nums[left] == nums[left-1]);
        return left;
    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        break;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}

class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int base = 0;
        while (base < nums.length - 2) {

            int left = base + 1;
            int right = nums.length - 1;
            int target = 0 - nums[base];
            while (left < right) {

                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[base], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }

            base++;
        }


        return new ArrayList<>(result);
    }
}
