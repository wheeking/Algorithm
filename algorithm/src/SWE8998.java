import java.util.Arrays;
import java.util.Scanner;

public class SWE8998 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = sc.nextInt();   // 과제수
            int[] T = new int[N];   // 걸리는 날짜
            int[] D = new int[N];   // 마감 날

            for (int i = 0; i < N; i++) {
                T[i] = sc.nextInt();
                D[i] = sc.nextInt();
            }

            int deadline = 0;   // 마지막 마감일
            for (int i = 0; i < D.length; i++) {
                if (deadline <= D[i]) {
                    deadline = D[i];
                }
            }
            int[] check = new int[deadline];


        }
    }
}
