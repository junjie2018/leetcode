public class T0003 {

    public static void main(String[] args) {
        System.out.println(new T0003().new Solution().lengthOfLongestSubstring(""));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0, len = 0;

            Info info = new Info();

            while (right != s.length()) {
                info.put(s.charAt(right++));
                if (info.repeatFlag) {
                    while (left != right) {
                        info.remove(s.charAt(left++));
                        if (!info.repeatFlag) {
                            break;
                        }
                    }
                }
                len = Integer.max(len, right - left);
            }

            return len;
        }
    }

    class Info {
        private final int[] chars = new int[256];
        private boolean repeatFlag = false;

        void put(int c) {
            ++chars[c];
            if (chars[c] > 1) {
                repeatFlag = true;
            }
        }

        void remove(int c) {
            --chars[c];
            if (chars[c] == 1) {
                repeatFlag = false;
            }
        }
    }
}
