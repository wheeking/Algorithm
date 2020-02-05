import java.util.Arrays;
import java.util.Scanner;

public class SWEA1209_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = 100;

        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
            int[][] map = new int[len][len];
            int[] sumArr = new int[2*len+2];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            // 각 행의 합
            for (int i = 0; i < len; i++) {
                // 매번 초기화해야함. 여기서
                sum = 0;
                for (int j = 0; j < len; j++) {
                    sum += map[i][j];
                    sumArr[i] = sum;
                }
            }

            // 각 열의 합
            for (int i = 0; i < len; i++) {
                sum = 0;
                for (int j = 0; j < len; j++) {
                    sum += map[j][i];
                    sumArr[i+len] = sum;
                }
            }


            // 대각선
            sum = 0;
            for (int i = 0; i < len; i++) {
                sum += map[i][i];
            }
            sumArr[sumArr.length-2] = sum;

            sum = 0;
            for (int i = 0; i < len; i++) {
                sum += map[i][len-i-1];
            }
            sumArr[sumArr.length-1] = sum;

            Arrays.sort(sumArr);

            System.out.println("#" + test_case + " " + sumArr[sumArr.length-1]);
        } // end of test_case
    }
}
