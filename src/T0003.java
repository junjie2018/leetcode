public class T0003 {

    public static void main(String[] args) {
        System.out.println(new T0003().new Solution().lengthOfLongestSubstring(""));
    }

    class Solution {
        /*
            左右两个指针，统计两个指针所包含的内容中是否有字符重复
                1.如果重复，右指针自增，直到无重复字符
                2.如果没有重复，左指针自增，知道无重复字符
                3.重复1、2过程，直到又指针扫描完所有元素
            解决该问题时，用到了滑动窗口的思想
         */
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
