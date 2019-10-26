package T0278;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().firstBadVersion(5));
        System.out.println(new Solution().firstBadVersion(2126753390));
    }
}

class VersionControl {
    public boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
