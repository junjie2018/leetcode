package T6000;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 编写一个方法求一个字符串的字节长度
 */
class T001 {
    public int getWordCount(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            length = (ascii >= 0 && ascii <= 255) ? length + 1 : length + 2;
        }
        return length;
    }
}

/**
 * 一个台阶有n级台阶，一次可以走1级，2级或3级，问走完n级台阶有多少中走法
 */
class T002 {

    public static int countWays(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
}

/**
 * 输入一个正整数，将其分解为素数的乘积
 */
class T003 {
    private static List<Integer> getPrimeFactor(int n) {
        List<Integer> result = new ArrayList<>();

        int tmp = n;
        for (int i = 2; i <= tmp; i++) {
            if (tmp % i == 0) {
                tmp /= i;
                result.add(i);
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeFactor(90));
    }
}

/**
 * 用递归实现字符串倒转
 */
class T004 {
    private static String stringReverse(String string) {
        if (string.length() == 1) {
            return string;
        }
        return string.charAt(string.length() - 1) + stringReverse(string.substring(0, string.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(stringReverse("你好"));
    }
}

/**
 * 367.	对于一个有N个整数元素的一维数组，找出它的子数组
 * （数组中下标连续的元素组成的数组）之和的最大值。
 */
class T005 {
    private static int getMaxSum(int[] array) {
        int idx = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        while (idx < array.length) {
            sum += array[idx];
            maxSum = sum > maxSum ? sum : maxSum;
            if (sum < 0) sum = 0;
            idx++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[]{
                -9, -2, -3, -5, -3
        }));
    }
}

/**
 * 全排列：给出五个数字12345的所有排列。
 */
class T006 {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] array;
    private int len;

    private boolean isAllDispose(boolean[] flag) {
        for (boolean i : flag) {
            if (!i) return false;
        }
        return true;
    }

    private void getFullPermutation(int[] array) {
        this.array = array;
        this.len = array.length;

        getFullPermutationCore(new LinkedHashSet<>());
    }

    private void getFullPermutationCore(LinkedHashSet<Integer> set) {
        if (set.size() >= len) {
            result.add(new ArrayList<>(set));
            return;
        }

        for (int i : array) {
            if (!set.contains(i)) {
                LinkedHashSet<Integer> tmp = new LinkedHashSet<>(set);
                tmp.add(i);
                getFullPermutationCore(tmp);
            }
        }
    }

    public static void main(String[] args) {
        T006 t = new T006();
        t.getFullPermutation(new int[]{
                1, 2, 3, 4, 5
        });
        System.out.println(t.result);
    }
}

/**
 * 找出11~9999之间的所有回文数
 */
class T007 {
    private static List<Integer> getPalindromicNumber(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPalindromicNumber(i)) result.add(i);
        }
        return result;
    }

    private static boolean isPalindromicNumber(int n) {
        String num = String.valueOf(n);
        int end = num.length() - 1;
        for (int i = 0; i <= end / 2; i++) {
            if (num.charAt(i) != num.charAt(end - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPalindromicNumber(11, 9999));
    }
}

/**
 * 输入年月日，计算该日期是这一年的第几天。
 */
class T008 {
    private static int daysInYear(int year, int month, int day) {
        int days = 0;
        for (int i = month; i > 0; i--) {
            if (i == month) days += day;
            else if (i == 12 || i == 10 || i == 8 || i == 7 || i == 5 || i == 3 || i == 1) {
                days += 31;
            } else {
                if (month == 2) {
                    days += isLeapYear(year) ? 28 : 29;
                } else {
                    days += 30;
                }
            }
        }
        return days;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        System.out.println(daysInYear(2019, 2, 5));
    }
}

/**
 * 统计一篇英文文章单词个数
 */
class T009 {
    private static int wordCount(String filePath) {
        int words = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = br.readLine();
            line = line.replace('.', ' ');
            line = line.replace(',', ' ');
            line = line.trim();
            words += line.split("\\s+").length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}

/**
 * 判断身份证：要么是15位，要么是18位，最后一位可以为字母
 * 并写出程序提出其中年月日判断身份证
 */
class T010 {
    private static boolean judage(String ID) {
        return Pattern.matches("\\d{15}|\\d{18}", ID);
    }

    private static String getYearMonthAndDay(String ID) {
        return ID.substring(5, 10);
    }
}


/**
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符保证字符串中有重复的字符，
 * 字符串的长度小于等于500.
 */
class T011 {
    private static int findDuplication(String str) {
        boolean[] flag = new boolean[255];
        for (int i = 0; i < str.length(); i++) {
            if (flag[str.charAt(i)]) {
                return str.charAt(i);
            }
            flag[str.charAt(i)] = true;
        }
        return 0;
    }
}

/**
 * 写一个完整函数，实现拷贝数组
 */
class T012 {
    private int[] copyArray(int[] source) {
        return Arrays.copyOf(source, source.length);
    }
}

/**
 * 手写9*9乘法表
 */
class T013 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%2d*%2d=%2d", j, i, i * j);
            }
            System.out.println();
        }
    }
}

/**
 * 给定一个整数数组，找到是否该数组包含任何重复数字。
 * 返回true：只要有任何数字在该数组中重复出现
 * 否则返回false。
 */
class T014 {
    private boolean isDumplication(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        return set.size() == array.length;
    }
}

/**
 * 328.	给定一个数组nums， 写一个函数来移动所有0元素到数组末尾，
 * 同时维持数组中非0元素的相对顺序不变。要求不能申请额外的内存空间，
 * 并且最小化操作次数。
 */
class T015 {
    private void removeZeroToHead(int[] nums) {
        int zeroCounts = 0;
        for (int num : nums) {
            if (num == 0) zeroCounts++;
        }

        // 移动非零元素
        int fast = nums.length - 1, slow = nums.length - 1;
        while (fast >= 0) {
            if (nums[fast] != 0) {
                nums[slow--] = nums[fast];
            }
            fast--;
        }

        // 移动零元素
        while (slow >= 0) {
            nums[slow--] = 0;
        }
    }
}






