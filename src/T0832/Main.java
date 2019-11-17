package T0832;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] arr : A) {
            int mid = arr.length / 2;
            for (int i = 0; i < mid; i++) {
                if (arr[i] != arr[arr.length - 1 - i]) {
                    int tmp = arr[i];
                    arr[i] = arr[arr.length - 1 - i];
                    arr[arr.length - 1 - i] = tmp;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }

        return A;
    }
}
