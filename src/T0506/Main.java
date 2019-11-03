package T0506;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public String[] findRelativeRanks(int[] nums) {
        List<Tuple> tuples = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tuples.add(new Tuple(i, nums[i]));
        }
        tuples.sort((a, b) -> Integer.compare(b.grade, a.grade));

        String[] result = new String[nums.length];
        for (int i = 0; i < tuples.size(); i++) {
            switch (i) {
                case 0:
                    result[tuples.get(i).idx] = "Gold Medal";
                    break;
                case 1:
                    result[tuples.get(i).idx] = "Silver Medal";
                    break;
                case 2:
                    result[tuples.get(i).idx] = "Bronze Medal";
                    break;
                default:
                    result[tuples.get(i).idx] = String.valueOf(i + 1);
                    break;

            }
        }
        return result;
    }

    private static class Tuple {
        int idx;
        int grade;

        public Tuple(int idx, int grade) {
            this.idx = idx;
            this.grade = grade;
        }
    }
}