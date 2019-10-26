package T0303;

public class Main {
    public static void main(String[] args) {

    }
}

class NumArray {

    private int[] nums;

    private int[] l2r;

    public NumArray(int[] nums) {

        if (nums == null || nums.length == 0) return;

        this.nums = nums;
        this.l2r = new int[nums.length];
        l2r[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            l2r[i] = l2r[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return l2r[j];
        else return l2r[j] - l2r[i - 1];
    }
}
