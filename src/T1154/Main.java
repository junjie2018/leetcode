package T1154;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().dayOfYear("2019-01-09"));
    }
}

class Solution {
    public int dayOfYear(String date) {
        String[] split = date.split("-");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        int[] days = new int[]{0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};

        return month <= 2 ? days[month] + day : isLeapYear(year) ? days[month] + day : days[month] + day - 1;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
