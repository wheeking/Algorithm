import java.util.Arrays;
import java.util.Scanner;

public class SWEA1486_장훈이선반 {
    public static int N;
    public static int height;
    public static int[] keys;
    public static int[] sumArr;
    public static int[] check;  // 1이면 넣기, 0이면 ㄴ
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int test_case = 1; test_case <= TC; test_case++) {
            cnt = 0;
            N = sc.nextInt();
            height = sc.nextInt();
            keys = new int[N];
            check = new int[N];
            sumArr = new int[(int) Math.pow(2, N)];
            // 입력
            for (int i = 0; i < N; i++) {
                keys[i] = sc.nextInt();
            }
            powerSet(0);

            Arrays.sort(sumArr);
            int ans = 0;

            for (int i = 0; i < sumArr.length; i++) {
                if (sumArr[i] >= height) {
                    ans = sumArr[i];
                    break;
                }
            }

            ans -= height;
            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static void powerSet(int k) {
        if (k == N) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                if (check[i] == 1) {
                    sum += keys[i];
                }
            }
            sumArr[cnt++] = sum;
            return;
        }
        // else
        check[k] = 0;
        powerSet(k+1);
        check[k] = 1;
        powerSet(k+1);
    }
}
