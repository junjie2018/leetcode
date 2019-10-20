package T0668;

public class Main {
    public static void main(String[] args) {

    }
}

/*
    这道题不会啊
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        int l = 1, r = n * m;
        int mid, ans = n * m;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (check(mid, n, m) >= k) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int check(int mid, int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += Math.min(m, mid / i);
        }
        return ans;
    }
}

/*
    我自己理解后的编码
 */
class Solution2 {
    private int check(int mid, int n, int m) {
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += Math.min(n, mid / i);
        }
        return ans;
    }

    public int findKthNumber(int m, int n, int k) {
        // 我喜欢用m做行
        if (m > n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        int left = 1, right = m * n;
        int mid, ans = m * n;

        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (check(mid, m, n) >= k) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
