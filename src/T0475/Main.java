package T0475;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] tmp = new int[]{1, 3, 5, 7, 9};
//        System.out.println(Arrays.binarySearch(tmp, 4));
        System.out.println(new Solution().findRadius(
//                CommonUtils.createInt1a("[5,6,7]"),
//                CommonUtils.createInt1a("[1,2,3,4]"),
                CommonUtils.createInt1a("[1]"),
//                CommonUtils.createInt1a("[1,2,3,8,9,10]")
                CommonUtils.createInt1a("[1,2,34]")
//                CommonUtils.createInt1a("[2]")
//                CommonUtils.createInt1a("[282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]"),
//                CommonUtils.createInt1a("[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]")
        ));
    }
}

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int maxDistance = 0;
        for (int house : houses) {
            int searchRes = Arrays.binarySearch(heaters, house);
            if (searchRes < 0) {
                int insertPosition = -searchRes - 1;
                int distance;
                if (insertPosition == 0) {
                    distance = heaters[insertPosition] - house;
                } else if (insertPosition == heaters.length) {
                    distance = house - heaters[heaters.length - 1];
                } else {
                    distance = Math.min(heaters[insertPosition] - house, house - heaters[insertPosition - 1]);
                }
                maxDistance = Math.max(maxDistance, distance);
            }
        }
        return maxDistance;
    }
}